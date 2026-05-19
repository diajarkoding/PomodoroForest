package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun TimerText(
    time: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = time,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.displayLarge,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun TimerTextPreview() {
    FocusTimerTheme {
        TimerText(time = "25:00")
    }
}
