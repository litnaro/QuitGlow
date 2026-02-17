package com.andriylitnarovych.quitglow.core.designsystem.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Primary action button.
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}