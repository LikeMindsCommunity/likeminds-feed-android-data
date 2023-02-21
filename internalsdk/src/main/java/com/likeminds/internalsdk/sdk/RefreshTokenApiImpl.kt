package com.likeminds.internalsdk.sdk

import com.likeminds.internalsdk.sdk.model.RefreshTokenResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class RefreshTokenApiImpl @Inject constructor(
    private val refreshTokenReceiver: RefreshTokenReceiver,
) : RefreshTokenApi {
    override suspend fun refreshAccessToken(refreshToken: String): NetworkResponse<RefreshTokenResponse> {
        return refreshTokenReceiver.refreshAccessToken(refreshToken)
    }
}