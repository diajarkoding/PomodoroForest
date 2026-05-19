package com.diajarkoding.pomodoroforest.domain.model

data class FocusSession(
    val id: Long = 0,
    val durationMinutes: Int,
    val completedAtMillis: Long,
    val treeStage: TreeStage,
)
