package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._RefreshTokenResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface RefreshTokenApi {

    suspend fun refreshAccessToken(
        refreshToken: String,
    ): NetworkResponse<_RefreshTokenResponse_>
}