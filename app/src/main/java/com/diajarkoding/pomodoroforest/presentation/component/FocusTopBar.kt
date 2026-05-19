package com.diajarkoding.pomodoroforest.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.diajarkoding.pomodoroforest.presentation.theme.FocusTimerTheme

@Composable
fun FocusTopBar(
    onMenuClick: () -> Unit,
    onSoundClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f),
            )
        }
        IconButton(onClick = onSoundClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.VolumeOff,
                contentDescription = "Sound",
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4FA88A)
@Composable
private fun FocusTopBarPreview() {
    FocusTimerTheme {
        FocusTopBar(onMenuClick = {}, onSoundClick = {})
    }
}
