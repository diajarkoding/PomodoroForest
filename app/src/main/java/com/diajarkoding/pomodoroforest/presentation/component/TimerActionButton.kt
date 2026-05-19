package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun TimerActionButton(
    text: String,
    isPrimary: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (isPrimary) {
        Button(
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimary,
            ),
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun TimerActionButtonPrimaryPreview() {
    FocusTimerTheme {
        TimerActionButton(text = "Plant", isPrimary = true, onClick = {})
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun TimerActionButtonSecondaryPreview() {
    FocusTimerTheme {
        TimerActionButton(text = "Give Up", isPrimary = false, onClick = {})
    }
}
