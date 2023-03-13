package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _RefreshTokenResponse_(
    var success: Boolean,
    var errorMessage: String?,
    var data: _RefreshTokenData_,
)

data class _RefreshTokenData_(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("refresh_token")
    var refreshToken: String,
)
