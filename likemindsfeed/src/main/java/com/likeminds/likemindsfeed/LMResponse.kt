package com.likeminds.likemindsfeed

data class LMResponse<T>(
    var success: Boolean,
    var errorMessage: String?,
    var data: T? = null
)