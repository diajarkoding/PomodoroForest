package com.diajarkoding.pomodoroforest.data.local

data class FocusSessionEntity(
    val id: Long = 0,
    val durationMinutes: Int,
    val status: String,
    val createdAt: Long,
)
