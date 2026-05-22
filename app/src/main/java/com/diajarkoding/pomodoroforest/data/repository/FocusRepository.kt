package com.diajarkoding.pomodoroforest.data.repository

import com.diajarkoding.pomodoroforest.data.local.FocusSessionDao
import com.diajarkoding.pomodoroforest.data.local.FocusSessionEntity
import com.diajarkoding.pomodoroforest.domain.model.FocusSession
import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

class FocusRepository(
    private val focusSessionDao: FocusSessionDao,
) {
    fun getFocusSessions(): List<FocusSession> = focusSessionDao.getAllSessions().map { entity ->
        val status = TimerStatus.valueOf(entity.status)
        FocusSession(
            id = entity.id,
            durationMinutes = entity.durationMinutes,
            remainingSeconds = 0,
            status = status,
            treeStage = if (status == TimerStatus.Finished) TreeStage.FullTree else TreeStage.Seed,
            createdAt = entity.createdAt,
        )
    }

    fun saveFocusSession(session: FocusSession) {
        focusSessionDao.insertSession(
            FocusSessionEntity(
                id = session.id,
                durationMinutes = session.durationMinutes,
                status = session.status.name,
                createdAt = session.createdAt,
            )
        )
    }
}
