package com.diajarkoding.pomodoroforest.data.repository

import com.diajarkoding.pomodoroforest.data.local.FocusSessionDao
import com.diajarkoding.pomodoroforest.data.local.FocusSessionEntity
import com.diajarkoding.pomodoroforest.domain.model.FocusSession
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

class FocusRepository(
    private val focusSessionDao: FocusSessionDao,
) {
    fun getFocusSessions(): List<FocusSession> = focusSessionDao.getAllSessions().map { entity ->
        FocusSession(
            id = entity.id,
            durationMinutes = entity.durationMinutes,
            completedAtMillis = entity.completedAtMillis,
            treeStage = TreeStage.valueOf(entity.treeStage),
        )
    }

    fun saveFocusSession(session: FocusSession) {
        focusSessionDao.insertSession(
            FocusSessionEntity(
                id = session.id,
                durationMinutes = session.durationMinutes,
                completedAtMillis = session.completedAtMillis,
                treeStage = session.treeStage.name,
            )
        )
    }
}
