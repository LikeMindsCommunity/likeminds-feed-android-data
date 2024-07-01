package com.likeminds.internalsdk.sdk

import android.util.Log
import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.FeedSDK.Companion.LOG_TAG
import com.likeminds.internalsdk.FeedTokenManager
import com.likeminds.internalsdk.sdk.util.SDKPreferences
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import kotlinx.coroutines.runBlocking
import okhttp3.*
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val sdkPreferences: SDKPreferences
) : Authenticator {
    companion object {
        private const val AUTH = "Authorization"
    }


    override fun authenticate(route: Route?, response: Response): Request? {
        val endPoint = response.request.url.toString()
        val method = response.request.method
        val code = response.code
        val feedTokenManager = FeedTokenManager.getInstance()
        val feedSDK = FeedSDK.getInstance()
        val lmInternalCallback = feedSDK.lmInternalCallback
        val refreshTokenNetworkApi = feedSDK.refreshTokenApiImpl

        Log.d("PUI", "code: $code endPoint: $endPoint method:$method")

        return if (code == 401) {
            Log.d("PUI", "401 authenticate endPoint: $endPoint method:$method")
            if (!endPoint.contains("user/refresh", false)) {
                Log.d("PUI", "new access token")
                val refreshToken = feedTokenManager.refreshToken
                runBlocking {
                    when (val refreshResponse =
                        refreshTokenNetworkApi.refreshAccessToken("Bearer $refreshToken")) {
                        is NetworkResponse.Error -> {
                            Log.d(
                                LOG_TAG,
                                "access token refresh failed: ${refreshResponse.body.errorMessage}"
                            )
                            null
                        }

                        is NetworkResponse.Success -> {
                            Log.d(LOG_TAG, "access token refreshed")

                            val newAccessToken = refreshResponse.body.data?.accessToken ?: ""
                            val newRefreshToken = refreshResponse.body.data?.refreshToken ?: ""
                            val updatedToken = "Bearer $newAccessToken"

                            //update token manager
                            feedTokenManager.updateTokens(newAccessToken, newRefreshToken)

                            //update local prefs
                            sdkPreferences.setAccessToken(newAccessToken)
                            sdkPreferences.setRefreshToken(newRefreshToken)

                            Log.d(
                                "PUI", """
                                Internal Data Layer Callback -> onAccessTokenExpiredAndRefreshed
                                accessToken: $newAccessToken
                                refreshToken: $newRefreshToken
                            """.trimIndent()
                            )

                            //through callback
                            lmInternalCallback?.onAccessTokenExpiredAndRefreshed(
                                newAccessToken,
                                newRefreshToken
                            )

                            //retry api
                            response.request.newBuilder()
                                .header(AUTH, updatedToken)
                                .build()
                        }
                    }
                }
            } else {
                Log.d("PUI", "new refresh token")
                feedTokenManager.clear()
                val tokens = lmInternalCallback?.onRefreshTokenExpired()

                val newAccessToken = tokens?.first ?: ""
                val newRefreshToken = tokens?.second ?: ""

                //update token manager
                feedTokenManager.updateTokens(newAccessToken, newRefreshToken)

                //update local prefs
                sdkPreferences.setAccessToken(newAccessToken)
                sdkPreferences.setRefreshToken(newRefreshToken)

                response.request.newBuilder()
                    .header(AUTH, newRefreshToken)
                    .build()
            }
        } else {
            Log.d("PUI", "200 authenticate endPoint: $endPoint method:$method")
            response.request
        }
    }
}