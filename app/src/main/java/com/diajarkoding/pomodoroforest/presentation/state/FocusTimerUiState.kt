package com.diajarkoding.pomodoroforest.presentation.state

import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

data class FocusTimerUiState(
    val durationMinutes: Int = 25,
    val totalSeconds: Int = durationMinutes * 60,
    val remainingSeconds: Int = totalSeconds,
    val status: TimerStatus = TimerStatus.Idle,
    val treeStage: TreeStage = TreeStage.Seed,
    val progress: Float = 0f,
    val motivationText: String = "Start planting today!",
    val primaryButtonText: String = "Plant",
    val isPrimaryButton: Boolean = true
)
