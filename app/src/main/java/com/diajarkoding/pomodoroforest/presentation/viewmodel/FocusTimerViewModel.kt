package com.diajarkoding.pomodoroforest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diajarkoding.pomodoroforest.domain.logic.TimerCalculator
import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.presentation.state.FocusTimerUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val DEFAULT_DURATION_MINUTES = 25
private const val ONE_SECOND_MILLIS = 1_000L

class FocusTimerViewModel : ViewModel() {

    private val durationMinutes: Int = DEFAULT_DURATION_MINUTES
    private val totalSeconds: Int = durationMinutes * 60

    private var remainingSeconds: Int = totalSeconds
    private var status: TimerStatus = TimerStatus.Idle
    private var timerJob: Job? = null

    private val _uiState = MutableStateFlow(buildUiState())
    val uiState: StateFlow<FocusTimerUiState> = _uiState.asStateFlow()

    fun handlePrimaryAction() {
        when (status) {
            TimerStatus.Idle,
            TimerStatus.Finished,
            TimerStatus.Cancelled -> {
                resetTimer()
                startTimer()
            }
            TimerStatus.Running -> cancelTimer()
            TimerStatus.Paused -> startTimer()
        }
    }

    private fun startTimer() {
        if (status == TimerStatus.Running) return

        status = TimerStatus.Running
        updateUiState()

        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (remainingSeconds > 0 && status == TimerStatus.Running) {
                delay(ONE_SECOND_MILLIS)
                remainingSeconds -= 1
                updateUiState()
            }
            if (remainingSeconds <= 0 && status == TimerStatus.Running) {
                finishTimer()
            }
        }
    }

    private fun cancelTimer() {
        timerJob?.cancel()
        timerJob = null
        status = TimerStatus.Cancelled
        remainingSeconds = totalSeconds
        updateUiState()
    }

    private fun finishTimer() {
        timerJob = null
        status = TimerStatus.Finished
        remainingSeconds = 0
        updateUiState()
    }

    private fun resetTimer() {
        timerJob?.cancel()
        timerJob = null
        status = TimerStatus.Idle
        remainingSeconds = totalSeconds
    }

    private fun updateUiState() {
        _uiState.value = buildUiState()
    }

    private fun buildUiState(): FocusTimerUiState {
        val progress = TimerCalculator.calculateProgress(totalSeconds, remainingSeconds)
        return FocusTimerUiState(
            durationMinutes = durationMinutes,
            totalSeconds = totalSeconds,
            remainingSeconds = remainingSeconds,
            status = status,
            treeStage = TimerCalculator.getTreeStage(progress),
            progress = progress,
            motivationText = TimerCalculator.getMotivationText(status),
            primaryButtonText = TimerCalculator.getPrimaryButtonText(status),
            isPrimaryButton = TimerCalculator.isPrimaryButton(status),
        )
    }
}
