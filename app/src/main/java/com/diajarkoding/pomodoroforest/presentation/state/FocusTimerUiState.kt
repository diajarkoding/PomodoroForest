package com.diajarkoding.pomodoroforest.presentation.state

import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

data class FocusTimerUiState(
    val durationMinutes: Int = 25,
    val remainingSeconds: Int = 25 * 60,
    val status: TimerStatus = TimerStatus.Idle,
    val treeStage: TreeStage = TreeStage.Seed,
)
