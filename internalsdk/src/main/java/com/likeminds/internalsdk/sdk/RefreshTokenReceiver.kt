package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._RefreshTokenRequest_
import com.likeminds.internalsdk.sdk.model._RefreshTokenResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class RefreshTokenReceiver @Inject constructor(
    private val refreshTokenNetworkApi: RefreshTokenNetworkApi,
) {
    suspend fun refreshAccessToken(
        refreshToken: String
    ): NetworkResponse<APIResponse<_RefreshTokenResponse_>> {

        val request = _RefreshTokenRequest_.Builder()
            .tokenExpiryBeta(1)
            .build()

        return refreshTokenNetworkApi.refreshAccessToken(refreshToken, request)
    }
}