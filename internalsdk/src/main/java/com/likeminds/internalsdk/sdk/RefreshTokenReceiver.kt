package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model._RefreshTokenResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class RefreshTokenReceiver @Inject constructor(
    private val refreshTokenNetworkApi: RefreshTokenNetworkApi,
) {
    suspend fun refreshAccessToken(refreshToken: String): NetworkResponse<_RefreshTokenResponse_> {
        return refreshTokenNetworkApi.refreshAccessToken(refreshToken)
    }
}