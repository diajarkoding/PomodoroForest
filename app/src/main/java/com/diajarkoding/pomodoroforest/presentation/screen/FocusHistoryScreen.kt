package com.diajarkoding.pomodoroforest.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.diajarkoding.pomodoroforest.presentation.component.EmptyHistoryState
import com.diajarkoding.pomodoroforest.presentation.component.FocusSessionCard
import com.diajarkoding.pomodoroforest.presentation.theme.FocusSpace
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

data class FocusHistoryItem(
    val durationText: String,
    val statusText: String,
    val treeEmoji: String,
)

@Composable
fun FocusHistoryScreen(
    sessions: List<FocusHistoryItem> = emptyList(),
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier.padding(FocusSpace.large),
        ) {
            item {
                Text(
                    text = "Focus History",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.height(FocusSpace.large))
            }

            if (sessions.isEmpty()) {
                item { EmptyHistoryState() }
            } else {
                items(sessions) { session ->
                    FocusSessionCard(
                        durationText = session.durationText,
                        statusText = session.statusText,
                        treeEmoji = session.treeEmoji,
                        modifier = Modifier.padding(bottom = FocusSpace.medium),
                    )
                }
            }
        }
    }
}

private val previewSessions = listOf(
    FocusHistoryItem("25 minutes", "Completed", "\uD83C\uDF32"),
    FocusHistoryItem("45 minutes", "Completed", "\uD83C\uDF32"),
    FocusHistoryItem("10 minutes", "Cancelled", "\uD83C\uDF31"),
)

@Preview(showBackground = true)
@Composable
private fun FocusHistoryScreenWithDataPreview() {
    FocusTimerTheme {
        FocusHistoryScreen(sessions = previewSessions)
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusHistoryScreenEmptyPreview() {
    FocusTimerTheme {
        FocusHistoryScreen(sessions = emptyList())
    }
}
