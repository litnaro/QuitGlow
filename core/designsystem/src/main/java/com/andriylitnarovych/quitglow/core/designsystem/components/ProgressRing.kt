package com.andriylitnarovych.quitglow.core.designsystem.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Circular progress indicator used for visualizing milestones.
 *
 * @param progress Value in range [0f..1f]
 */
@Composable
fun ProgressRing(
    progress: Float,
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        progress = { progress.coerceIn(0f, 1f) },
        modifier = modifier
    )
}