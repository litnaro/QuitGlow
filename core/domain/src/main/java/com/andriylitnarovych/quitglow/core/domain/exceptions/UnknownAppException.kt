package com.andriylitnarovych.quitglow.core.domain.exceptions

/**
 * Represents an unexpected, non-recoverable application error.
 *
 * Used when no specific error classification is available.
 */
class UnknownAppException(
    cause: Throwable? = null
) : AbstractAppException(
    message = cause?.message,
    cause = cause
)