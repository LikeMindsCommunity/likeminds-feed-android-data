package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    var success: Boolean,
    var errorMessage: String?,
    var data: RefreshTokenData,
)

data class RefreshTokenData(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("refresh_token")
    var refreshToken: String,
)
