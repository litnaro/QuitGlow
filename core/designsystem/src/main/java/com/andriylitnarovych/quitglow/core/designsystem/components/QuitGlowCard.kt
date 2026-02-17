package com.andriylitnarovych.quitglow.core.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.andriylitnarovych.quitglow.core.designsystem.theme.Dimens

/**
 * Standard card component used across the application.
 */
@Composable
fun QuitGlowCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(Dimens.SpaceM)
        ) {
            content()
        }
    }
}