package com.diajarkoding.pomodoroforest.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diajarkoding.pomodoroforest.domain.logic.TimerCalculator
import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.presentation.component.FocusTopBar
import com.diajarkoding.pomodoroforest.presentation.component.MotivationText
import com.diajarkoding.pomodoroforest.presentation.component.TimerActionButton
import com.diajarkoding.pomodoroforest.presentation.component.TimerText
import com.diajarkoding.pomodoroforest.presentation.component.TreeIllustration
import com.diajarkoding.pomodoroforest.presentation.state.FocusTimerUiState
import com.diajarkoding.pomodoroforest.presentation.theme.FocusSpace
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme
import androidx.compose.ui.tooling.preview.Preview
import com.diajarkoding.pomodoroforest.domain.model.TreeStage

@Composable
fun FocusTimerScreen(
    uiState: FocusTimerUiState = FocusTimerUiState(),
    onPrimaryActionClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onSoundClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val isRunning = uiState.status == TimerStatus.Running
    val buttonText = when (uiState.status) {
        TimerStatus.Idle -> "Plant"
        TimerStatus.Running -> "Give Up"
        TimerStatus.Paused -> "Resume"
        TimerStatus.Finished -> "Plant Again"
    }
    val motivationText = when (uiState.status) {
        TimerStatus.Idle -> "Start planting today!"
        TimerStatus.Running -> "Put down your phone."
        TimerStatus.Paused -> "Take a breath, then continue."
        TimerStatus.Finished -> "Your tree has grown!"
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(FocusSpace.large),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FocusTopBar(
                onMenuClick = onMenuClick,
                onSoundClick = onSoundClick,
            )

            Spacer(modifier = Modifier.height(FocusSpace.hero))

            MotivationText(text = motivationText)

            Spacer(modifier = Modifier.height(FocusSpace.xxLarge))

            TreeIllustration(stage = uiState.treeStage)

            Spacer(modifier = Modifier.height(FocusSpace.xxLarge))

            TimerText(time = TimerCalculator.formatTime(uiState.remainingSeconds))

            Spacer(modifier = Modifier.height(FocusSpace.xLarge))

            TimerActionButton(
                text = buttonText,
                isPrimary = !isRunning,
                onClick = onPrimaryActionClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusTimerScreenIdlePreview() {
    FocusTimerTheme {
        FocusTimerScreen(
            uiState = FocusTimerUiState(
                remainingSeconds = 25 * 60,
                status = TimerStatus.Idle,
                treeStage = TreeStage.Seed,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusTimerScreenRunningPreview() {
    FocusTimerTheme {
        FocusTimerScreen(
            uiState = FocusTimerUiState(
                remainingSeconds = 18 * 60 + 42,
                status = TimerStatus.Running,
                treeStage = TreeStage.Sprout,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusTimerScreenFinishedPreview() {
    FocusTimerTheme {
        FocusTimerScreen(
            uiState = FocusTimerUiState(
                remainingSeconds = 0,
                status = TimerStatus.Finished,
                treeStage = TreeStage.FullTree,
            ),
        )
    }
}
