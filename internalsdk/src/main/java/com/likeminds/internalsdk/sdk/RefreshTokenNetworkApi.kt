package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._RefreshTokenRequest_
import com.likeminds.internalsdk.sdk.model._RefreshTokenResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RefreshTokenNetworkApi {

    @POST("user/refresh")
    suspend fun refreshAccessToken(
        @Header("Authorization") refreshToken: String,
        @Body request: _RefreshTokenRequest_? = null
    ): NetworkResponse<APIResponse<_RefreshTokenResponse_>>
}