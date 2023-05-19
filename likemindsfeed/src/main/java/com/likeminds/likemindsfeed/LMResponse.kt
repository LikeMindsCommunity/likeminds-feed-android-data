package com.likeminds.likemindsfeed

import androidx.annotation.Keep

@Keep
data class LMResponse<T>(
    var success: Boolean,
    var errorMessage: String? = null,
    var data: T? = null
)