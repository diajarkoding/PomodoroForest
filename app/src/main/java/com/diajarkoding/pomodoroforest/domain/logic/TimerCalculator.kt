package com.diajarkoding.pomodoroforest.domain.logic

import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

object TimerCalculator {
    fun formatTime(seconds: Int): String {
        val safeSeconds = seconds.coerceAtLeast(0)
        val minutes = safeSeconds / 60
        val remainingSeconds = safeSeconds % 60
        return "%02d:%02d".format(minutes, remainingSeconds)
    }

    fun calculateProgress(
        totalSeconds: Int,
        remainingSeconds: Int
    ): Float {
        if (totalSeconds <= 0) return 0f
        val elapsedSeconds = totalSeconds - remainingSeconds
        return (elapsedSeconds.toFloat() / totalSeconds)
            .coerceIn(0f, 1f)
    }

    fun getTreeStage(progress: Float): TreeStage {
        return when {
            progress < 0.25f -> TreeStage.Seed
            progress < 0.50f -> TreeStage.Sprout
            progress < 0.85f -> TreeStage.SmallTree
            else -> TreeStage.FullTree
        }
    }

    fun getMotivationText(status: TimerStatus): String {
        return when (status) {
            TimerStatus.Idle -> "Start planting today!"
            TimerStatus.Running -> "Put down your phone."
            TimerStatus.Paused -> "Take a breath, then continue."
            TimerStatus.Finished -> "Your tree has grown!"
            TimerStatus.Cancelled -> "Your tree stopped growing."
        }
    }

    fun getPrimaryButtonText(status: TimerStatus): String {
        return when (status) {
            TimerStatus.Idle -> "Plant"
            TimerStatus.Running -> "Give Up"
            TimerStatus.Paused -> "Resume"
            TimerStatus.Finished -> "Plant Again"
            TimerStatus.Cancelled -> "Try Again"
        }
    }

    fun isPrimaryButton(status: TimerStatus): Boolean {
        return status != TimerStatus.Running
    }
}
