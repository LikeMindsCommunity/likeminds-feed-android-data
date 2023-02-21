package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model.RefreshTokenResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface RefreshTokenApi {

    suspend fun refreshAccessToken(
        refreshToken: String,
    ): NetworkResponse<RefreshTokenResponse>
}