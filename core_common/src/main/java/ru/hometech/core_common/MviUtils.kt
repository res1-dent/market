package ru.hometech.core_common

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


interface Action
interface State

interface Reducer<S : State, A : Action> {
    fun reduce(state: S, action: A): S
}

interface SideEffect<S : State, A : Action> {
    fun perform(state: S, action: A): Flow<S>
}

abstract class BaseViewModel<S : State, A : Action>(
    private val reducer: Reducer<S, A>,
    private val sideEffect: SideEffect<S, A>,
    initialState: S
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    fun dispatch(action: A) {
        Log.d(this::class.simpleName, "ACTION: ${action::class.simpleName}")
        Log.d(this::class.simpleName, "CURRENT_STATE: ${_uiState.value}")
        val newState = reducer.reduce(_uiState.value, action)
        Log.d(this::class.simpleName, "REDUCED_STATE: $newState")
        _uiState.value = newState

        performSideEffect(newState, action)
    }

    private fun performSideEffect(state: S, action: A) {
        sideEffect.perform(state, action).onEach {
            Log.d(this::class.simpleName, "SIDE_EFFECT_PERFORM: $it")
            _uiState.value = it
        }.launchIn(viewModelScope)

    }
}
