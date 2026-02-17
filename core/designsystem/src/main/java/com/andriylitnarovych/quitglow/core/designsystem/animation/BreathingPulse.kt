package com.andriylitnarovych.quitglow.core.designsystem.animation

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

/**
 * Provides animated scale value used in breathing exercises.
 */
@Composable
fun breathingScale(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "breathing")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "breathingScale"
    )
    return scale
}