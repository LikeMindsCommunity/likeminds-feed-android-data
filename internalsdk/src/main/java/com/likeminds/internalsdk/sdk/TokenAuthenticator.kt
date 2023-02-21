package com.likeminds.internalsdk.sdk

import android.util.Log
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val sdkPreferences: SDKPreferences,
    private val refreshTokenNetworkApi: RefreshTokenNetworkApi
) : Authenticator {
    companion object {
        private const val AUTH = "Authorization"
        const val INVALID_LTM = "Invalid LTM!"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        return getUpdatedRequest(response)
    }

    private fun getUpdatedRequest(response: Response): Request? {
        val body = response.body?.string()
        return when {
            sdkPreferences.getRefreshToken().isEmpty() -> {
                Log.e("LikeMinds", "refresh token is empty")
                null
            }
            (body?.contains(INVALID_LTM, true) == true) -> {
                Log.d("LikeMinds", "refreshing access token")
                runBlocking {
                    val refreshToken = sdkPreferences.getRefreshToken()
                    when (val refreshResponse =
                        refreshTokenNetworkApi.refreshAccessToken("Bearer $refreshToken")) {
                        is NetworkResponse.Error -> {
                            Log.d(
                                "LikeMinds",
                                "access token refresh failed: ${refreshResponse.body.errorMessage}"
                            )
                            null
                        }
                        is NetworkResponse.Success -> {
                            Log.d("LikeMinds", "access token refreshed")
                            val newAccessToken = refreshResponse.body.data.accessToken
                            val newRefreshToken = refreshResponse.body.data.refreshToken
                            val updatedToken = "Bearer $newAccessToken"

                            sdkPreferences.setAccessToken(newAccessToken)
                            sdkPreferences.setAccessTokenTimeStamp(System.currentTimeMillis())
                            sdkPreferences.setRefreshToken(newRefreshToken)
                            response.request.newBuilder()
                                .header(AUTH, updatedToken)
                                .build()
                        }
                    }
                }
            }
            else -> {
                null
            }
        }
    }
}