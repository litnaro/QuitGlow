package com.andriylitnarovych.quitglow.core.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Displays a single progress metric (e.g. money saved, smoke-free time).
 */
@Composable
fun MetricTile(
    label: String,
    value: String
) {
    Column {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}