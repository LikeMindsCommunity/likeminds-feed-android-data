package com.likeminds.internalsdk.utils.retrofit.model

object NetworkConstants {
    const val MAX_RETRIES_ALLOWED = 3

    // error codes
    const val UNAUTHORIZED = 401
    private const val SERVER_ERROR = 500
    private const val BAD_GATEWAY = 502
    private const val SERVICE_UNAVAILABLE = 503
    private const val GATEWAY_TIMEOUT = 504
    private const val TOO_MANY_REQUESTS = 429

    val retryErrorCodes = setOf(
        SERVER_ERROR,
        BAD_GATEWAY,
        SERVICE_UNAVAILABLE,
        GATEWAY_TIMEOUT,
        TOO_MANY_REQUESTS
    )
}