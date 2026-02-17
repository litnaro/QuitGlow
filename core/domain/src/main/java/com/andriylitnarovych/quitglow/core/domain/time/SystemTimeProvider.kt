package com.andriylitnarovych.quitglow.core.domain.time

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * Default implementation using system clock.
 */
class SystemTimeProvider(
    private val clock: Clock = Clock.System
) : TimeProvider {

    override fun now(): Instant = clock.now()
}