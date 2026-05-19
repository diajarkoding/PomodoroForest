package com.diajarkoding.pomodoroforest.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val FocusColorScheme = lightColorScheme(
    primary = ForestGreen,
    secondary = ForestLightGreen,
    tertiary = ForestBrown,
    background = ForestGreen,
    surface = ForestCream,
    onPrimary = ForestWhite,
    onSecondary = ForestDarkGreen,
    onBackground = ForestWhite,
    onSurface = ForestDarkGreen,
)

@Composable
fun FocusTimerTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = FocusColorScheme,
        typography = FocusTypography,
        shapes = FocusShapes,
        content = content,
    )
}
