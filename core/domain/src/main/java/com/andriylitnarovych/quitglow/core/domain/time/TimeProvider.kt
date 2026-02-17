package com.andriylitnarovych.quitglow.core.domain.time

import kotlinx.datetime.Instant

/**
 * Abstraction over current time provider.
 *
 * Allows deterministic time control in tests.
 */
interface TimeProvider {

    /**
     * Returns the current moment in time.
     */
    fun now(): Instant
}