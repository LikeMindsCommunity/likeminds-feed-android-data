package com.likeminds.internalsdk.sdk

import android.util.Log
import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.FeedSDK.Companion.LOG_TAG
import com.likeminds.internalsdk.FeedTokenManager
import okhttp3.*
import javax.inject.Inject

class RefreshTokenAuthenticator @Inject constructor() : Authenticator {
    companion object {
        const val INVALID_RTM = "Invalid RTM!"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val body = response.body?.string()
        Log.d(
            LOG_TAG,
            "refreshing refresh token"
        )
        return if (body?.contains(INVALID_RTM, true) == true) {
            Log.d(LOG_TAG, "refresh token is expired, clearing tokens")
            val feedTokenManager = FeedTokenManager.getInstance()
            feedTokenManager.clear()
            val lmInternalCallback = FeedSDK.getInstance().lmInternalCallback
            lmInternalCallback?.login()
            null
        } else {
            Log.d(LOG_TAG, "refresh token failed, return null")
            null
        }
    }
}