package com.likeminds.internalsdk.sdk

import android.util.Log
import com.likeminds.internalsdk.TokenManager
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class RefreshTokenAuthenticator @Inject constructor() : Authenticator {
    companion object {
        const val INVALID_RTM = "Invalid RTM!"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val body = response.body?.string()
        Log.d(
            "LikeMinds",
            "refreshing refresh token"
        )
        return if (body?.contains(INVALID_RTM, true) == true) {
            Log.d("LikeMinds", "refresh token is expired, clearing db and prefs")
            val tokenManager = TokenManager.getInstance()
            tokenManager.updateTokens(null, null, null)
            null
        } else {
            Log.d("LikeMinds", "refresh token failed, return null")
            null
        }
    }
}