package com.diajarkoding.pomodoroforest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.presentation.state.FocusTimerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FocusTimerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FocusTimerUiState())
    val uiState: StateFlow<FocusTimerUiState> = _uiState.asStateFlow()

    fun toggleTimer() {
        val currentState = _uiState.value
        val nextStatus = if (currentState.status == TimerStatus.Running) {
            TimerStatus.Paused
        } else {
            TimerStatus.Running
        }

        _uiState.value = currentState.copy(status = nextStatus)
    }
}
