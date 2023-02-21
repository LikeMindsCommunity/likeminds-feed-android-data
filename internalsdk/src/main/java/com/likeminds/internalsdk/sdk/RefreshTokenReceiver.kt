package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model.RefreshTokenResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class RefreshTokenReceiver @Inject constructor(
    private val refreshTokenNetworkApi: RefreshTokenNetworkApi,
) {
    suspend fun refreshAccessToken(refreshToken: String): NetworkResponse<RefreshTokenResponse> {
        return refreshTokenNetworkApi.refreshAccessToken(refreshToken)
    }
}