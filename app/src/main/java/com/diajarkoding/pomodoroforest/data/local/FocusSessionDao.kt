package com.diajarkoding.pomodoroforest.data.local

interface FocusSessionDao {
    fun getAllSessions(): List<FocusSessionEntity>

    fun insertSession(session: FocusSessionEntity)
}
