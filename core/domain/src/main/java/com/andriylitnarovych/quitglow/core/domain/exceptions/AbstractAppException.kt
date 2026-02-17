package com.andriylitnarovych.quitglow.core.domain.exceptions

/**
 * Base type for application-level exceptions.
 *
 * All custom exceptions within the application should extend this class.
 * It allows distinguishing expected application errors from unexpected
 * system-level failures.
 */
abstract class AbstractAppException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)