package ru.hometech.core_common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

interface IntentProcessor<Intent> {
    suspend fun processIntent(intent: Intent)
}

interface ViewState<out State> {
    val state: StateFlow<State>
}

abstract class BaseViewModel<ViewStateType : Any, IntentType : Any>(
    initialState: ViewStateType
) : ViewModel(), ViewState<ViewStateType>, IntentProcessor<IntentType> {

    protected val _state = MutableStateFlow(initialState)
    override val state: StateFlow<ViewStateType>
        get() = _state.asStateFlow()

    protected val intent = MutableSharedFlow<IntentType>()

    init {
        viewModelScope.launch {
            intent.collect { processIntent(it) }
        }
    }

    fun submitIntent(intent: IntentType) {
        viewModelScope.launch {
            this@BaseViewModel.intent.emit(intent)
        }
    }
}
