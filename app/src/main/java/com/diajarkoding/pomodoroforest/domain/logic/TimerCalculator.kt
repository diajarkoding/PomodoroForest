package com.diajarkoding.pomodoroforest.domain.logic

import com.diajarkoding.pomodoroforest.domain.model.TreeStage

object TimerCalculator {
    fun formatTime(totalSeconds: Int): String {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return "%02d:%02d".format(minutes, seconds)
    }

    fun treeStage(progress: Float): TreeStage = when {
        progress >= 1f -> TreeStage.FullTree
        progress >= 0.66f -> TreeStage.SmallTree
        progress >= 0.33f -> TreeStage.Sprout
        else -> TreeStage.Seed
    }
}
