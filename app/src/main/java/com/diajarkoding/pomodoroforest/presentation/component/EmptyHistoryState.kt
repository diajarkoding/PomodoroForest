package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.diajarkoding.pomodoroforest.presentation.theme.FocusSpace
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun EmptyHistoryState(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "\uD83C\uDF31",
            fontSize = 48.sp,
        )
        Spacer(modifier = Modifier.height(FocusSpace.medium))
        Text(
            text = "Belum ada pohon yang ditanam",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(FocusSpace.xSmall))
        Text(
            text = "Mulai sesi fokus pertamamu hari ini",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun EmptyHistoryStatePreview() {
    FocusTimerTheme {
        EmptyHistoryState()
    }
}
