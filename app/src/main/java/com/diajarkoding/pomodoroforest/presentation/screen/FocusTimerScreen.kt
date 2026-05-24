package com.diajarkoding.pomodoroforest.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diajarkoding.pomodoroforest.domain.logic.TimerCalculator
import com.diajarkoding.pomodoroforest.domain.model.TimerStatus
import com.diajarkoding.pomodoroforest.domain.model.TreeStage
import com.diajarkoding.pomodoroforest.presentation.component.FocusTopBar
import com.diajarkoding.pomodoroforest.presentation.component.MotivationText
import com.diajarkoding.pomodoroforest.presentation.component.TimerActionButton
import com.diajarkoding.pomodoroforest.presentation.component.TimerText
import com.diajarkoding.pomodoroforest.presentation.component.TreeIllustration
import com.diajarkoding.pomodoroforest.presentation.state.FocusTimerUiState
import com.diajarkoding.pomodoroforest.presentation.theme.FocusSpace
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme
import com.diajarkoding.pomodoroforest.presentation.viewmodel.FocusTimerViewModel

/**
 * Stateful entry point untuk timer screen.
 *
 * Route bertugas menyambungkan ViewModel dengan FocusTimerScreen yang stateless.
 * Tetap pisahkan Route (stateful) dan Screen (stateless) supaya Screen mudah
 * dipreview dengan dummy state tanpa perlu inisialisasi ViewModel.
 */
@Composable
fun FocusTimerRoute(
    modifier: Modifier = Modifier,
    viewModel: FocusTimerViewModel = viewModel(),
    onMenuClick: () -> Unit = {},
    onSoundClick: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FocusTimerScreen(
        uiState = uiState,
        onPrimaryActionClick = viewModel::handlePrimaryAction,
        onMenuClick = onMenuClick,
        onSoundClick = onSoundClick,
        modifier = modifier,
    )
}

@Composable
fun FocusTimerScreen(
    uiState: FocusTimerUiState,
    onPrimaryActionClick: () -> Unit,
    onMenuClick: () -> Unit = {},
    onSoundClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(FocusSpace.large),
        ) {
            FocusTopBar(
                onMenuClick = onMenuClick,
                onSoundClick = onSoundClick,
                modifier = Modifier.align(Alignment.TopCenter),
            )
            FocusTimerMainContent(
                motivationText = uiState.motivationText,
                treeStage = uiState.treeStage,
                timerText = TimerCalculator.formatTime(uiState.remainingSeconds),
                buttonText = uiState.primaryButtonText,
                isPrimaryButton = uiState.isPrimaryButton,
                onPrimaryActionClick = onPrimaryActionClick,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun FocusTimerMainContent(
    motivationText: String,
    treeStage: TreeStage,
    timerText: String,
    buttonText: String,
    isPrimaryButton: Boolean,
    onPrimaryActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        MotivationText(text = motivationText)

        Spacer(modifier = Modifier.height(FocusSpace.xxLarge))

        TreeIllustration(stage = treeStage)

        Spacer(modifier = Modifier.height(FocusSpace.xxLarge))

        TimerText(time = timerText)

        Spacer(modifier = Modifier.height(FocusSpace.xLarge))

        TimerActionButton(
            text = buttonText,
            isPrimary = isPrimaryButton,
            onClick = onPrimaryActionClick,
        )
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
                motivationText = "Start planting today!",
                primaryButtonText = "Plant",
                isPrimaryButton = true,
            ),
            onPrimaryActionClick = {},
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
                progress = 0.25f,
                motivationText = "Put down your phone.",
                primaryButtonText = "Give Up",
                isPrimaryButton = false,
            ),
            onPrimaryActionClick = {},
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
                progress = 1f,
                motivationText = "Your tree has grown!",
                primaryButtonText = "Plant Again",
                isPrimaryButton = true,
            ),
            onPrimaryActionClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusTimerScreenCancelledPreview() {
    FocusTimerTheme {
        FocusTimerScreen(
            uiState = FocusTimerUiState(
                remainingSeconds = 25 * 60,
                status = TimerStatus.Cancelled,
                treeStage = TreeStage.Seed,
                motivationText = "Your tree stopped growing.",
                primaryButtonText = "Try Again",
                isPrimaryButton = true,
            ),
            onPrimaryActionClick = {},
        )
    }
}
