package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun MotivationText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.bodyLarge,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun MotivationTextPreview() {
    FocusTimerTheme {
        MotivationText(text = "Start planting today!")
    }
}
