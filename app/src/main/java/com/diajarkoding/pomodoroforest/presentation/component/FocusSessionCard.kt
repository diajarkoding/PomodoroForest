package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.diajarkoding.pomodoroforest.presentation.theme.FocusSpace
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun FocusSessionCard(
    durationText: String,
    statusText: String,
    treeEmoji: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(FocusSpace.medium),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = treeEmoji,
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.width(FocusSpace.medium))
            Column {
                Text(
                    text = "Focus Session",
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "$durationText \u2022 $statusText",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusSessionCardPreview() {
    FocusTimerTheme {
        FocusSessionCard(
            durationText = "25 minutes",
            statusText = "Completed",
            treeEmoji = "\uD83C\uDF32",
        )
    }
}
