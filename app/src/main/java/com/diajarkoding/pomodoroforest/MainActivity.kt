package com.diajarkoding.pomodoroforest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.diajarkoding.pomodoroforest.presentation.screen.FocusTimerScreen
import com.diajarkoding.pomodoroforest.presentation.screen.SplashScreen
import com.diajarkoding.pomodoroforest.presentation.state.FocusTimerUiState
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme
import com.diajarkoding.pomodoroforest.presentation.viewmodel.FocusTimerViewModel
import kotlinx.coroutines.delay

private const val SPLASH_DURATION_MILLIS = 1500L

class MainActivity : ComponentActivity() {
    private val viewModel: FocusTimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsState()

            FocusTimerTheme {
                FocusTimerApp(
                    uiState = uiState,
                    onPrimaryActionClick = viewModel::toggleTimer,
                )
            }
        }
    }
}

@Composable
private fun FocusTimerApp(
    uiState: FocusTimerUiState,
    onPrimaryActionClick: () -> Unit,
) {
    var showSplash by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(SPLASH_DURATION_MILLIS)
        showSplash = false
    }

    AnimatedVisibility(
        visible = showSplash,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        SplashScreen(modifier = Modifier.fillMaxSize())
    }

    AnimatedVisibility(
        visible = !showSplash,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        FocusTimerScreen(
            uiState = uiState,
            onPrimaryActionClick = onPrimaryActionClick,
        )
    }
}
