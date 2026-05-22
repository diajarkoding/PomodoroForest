package com.diajarkoding.pomodoroforest.domain.model

data class FocusSession(
    val id: Long = 0,
    val durationMinutes: Int,
    val remainingSeconds: Int,
    val status: TimerStatus,
    val treeStage: TreeStage,
    val createdAt: Long,
)
