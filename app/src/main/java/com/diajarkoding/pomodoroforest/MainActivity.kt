package com.diajarkoding.pomodoroforest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme
import com.diajarkoding.pomodoroforest.presentation.screen.FocusTimerScreen
import com.diajarkoding.pomodoroforest.presentation.viewmodel.FocusTimerViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: FocusTimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsState()

            FocusTimerTheme {
                FocusTimerScreen(
                    uiState = uiState,
                    onPrimaryActionClick = viewModel::toggleTimer,
                )
            }
        }
    }
}
