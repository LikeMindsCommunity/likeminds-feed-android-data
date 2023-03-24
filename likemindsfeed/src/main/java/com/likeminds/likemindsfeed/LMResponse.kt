package com.likeminds.likemindsfeed

data class LMResponse<T>(
    var success: Boolean,
    var errorMessage: String? = null,
    var data: T? = null
)