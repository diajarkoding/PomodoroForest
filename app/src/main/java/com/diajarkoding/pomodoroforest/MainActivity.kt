package com.diajarkoding.pomodoroforest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.diajarkoding.pomodoroforest.presentation.screen.FocusTimerRoute
import com.diajarkoding.pomodoroforest.presentation.screen.SplashScreen
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme
import kotlinx.coroutines.delay

private const val SPLASH_DURATION_MILLIS = 1500L

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Pasang system splash sebelum super.onCreate agar Android 12+ pakai
        // splash bawaan (background ForestGreen + logo aplikasi) selama
        // proses startup, lalu transisi mulus ke in-app splash.
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusTimerTheme {
                FocusTimerApp()
            }
        }
    }
}

@Composable
private fun FocusTimerApp() {
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
        FocusTimerRoute()
    }
}
