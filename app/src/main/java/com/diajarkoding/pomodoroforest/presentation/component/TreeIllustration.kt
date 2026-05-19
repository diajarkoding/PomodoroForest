package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diajarkoding.pomodoroforest.domain.model.TreeStage
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun TreeIllustration(
    stage: TreeStage,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(180.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = when (stage) {
                TreeStage.Seed -> "\uD83C\uDF31"
                TreeStage.Sprout -> "\uD83C\uDF3F"
                TreeStage.SmallTree -> "\uD83C\uDF33"
                TreeStage.FullTree -> "\uD83C\uDF32"
            },
            fontSize = 64.sp,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun TreeIllustrationPreview() {
    FocusTimerTheme {
        TreeIllustration(stage = TreeStage.Sprout)
    }
}
