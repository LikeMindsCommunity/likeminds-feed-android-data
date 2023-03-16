package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._RefreshTokenResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface RefreshTokenApi {

    // api to refresh access token
    suspend fun refreshAccessToken(
        refreshToken: String,
    ): NetworkResponse<APIResponse<_RefreshTokenResponse_>>
}