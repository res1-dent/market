package ru.hometech.core_common

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

interface IntentProcessor<Intent> {
    suspend fun processIntent(intent: Intent)
}

interface ViewState<out State> {
    val state: StateFlow<State>
}

abstract class BaseViewModel<ViewStateType : Any, IntentType : Any>(
    initialState: ViewStateType
) : ViewModel() {

    private val intent = MutableSharedFlow<IntentType>()

   /* init {
        viewModelScope.launch {
            intent.collect { processIntent(it) }
        }
    }*/

    fun submitIntent(intent: IntentType) {
        viewModelScope.launch {
            this@BaseViewModel.intent.emit(intent)
        }
    }
}

abstract class Base(): ViewModel() {

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e("!!!", "ex = $throwable")
    }

    protected val safeViewModelScope = viewModelScope + exceptionHandler


}
