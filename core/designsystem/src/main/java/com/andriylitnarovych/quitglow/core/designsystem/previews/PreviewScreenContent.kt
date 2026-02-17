package com.andriylitnarovych.quitglow.core.designsystem.previews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.andriylitnarovych.quitglow.core.designsystem.theme.QuitGlowTheme

/**
 * Wraps preview content with application theme and default surface.
 */
@Composable
fun PreviewScreenContent(
    content: @Composable () -> Unit
) {
    QuitGlowTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}
