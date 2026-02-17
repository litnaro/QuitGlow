package com.andriylitnarovych.quitglow.core.domain.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provides coroutine dispatchers used across the application.
 *
 * Enables dispatcher substitution in tests.
 */
interface AppDispatchers {

    /**
     * Dispatcher intended for CPU-intensive work.
     */
    val default: CoroutineDispatcher

    /**
     * Dispatcher intended for IO-bound work.
     */
    val io: CoroutineDispatcher
}