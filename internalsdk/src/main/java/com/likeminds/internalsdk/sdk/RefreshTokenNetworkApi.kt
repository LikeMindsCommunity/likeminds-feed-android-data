package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model.RefreshTokenResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Header
import retrofit2.http.POST

interface RefreshTokenNetworkApi {

    @POST("user/refresh")
    suspend fun refreshAccessToken(
        @Header("Authorization") refreshToken: String,
    ): NetworkResponse<RefreshTokenResponse>
}