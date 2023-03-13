package com.collabmates.sdk

import android.util.Log
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.sdk.SDKPreferences
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class RefreshTokenAuthenticator @Inject constructor(
    private val sdkPreferences: SDKPreferences
) : Authenticator {
    companion object {
        const val INVALID_RTM = "Invalid RTM!"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val body = response.body?.string()
        Log.d(
            CollabmatesSDK.TAG,
            "refreshing refresh token"
        )
        return if (body?.contains(INVALID_RTM, true) == true) {
            Log.d(CollabmatesSDK.TAG, "refresh token is expired, clearing db and prefs")
            sdkPreferences.clear()
            null
        } else {
            Log.d(CollabmatesSDK.TAG, "refresh token failed, return null")
            null
        }
    }
}