package com.likeminds.feedsdk

import android.app.Application
import android.util.Log
import com.likeminds.likemindsfeed.LMFeedSDKCallback
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
import kotlinx.coroutines.runBlocking

class MainApplication : Application(), LMFeedSDKCallback {

    private lateinit var mFeedClient: LMFeedClient

    override fun onCreate() {
        super.onCreate()

        mFeedClient = LMFeedClient.Builder(this)
            .lmCallback(this)
            .build()
    }


    override fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String) {
    }

    override fun onRefreshTokenExpired(): Pair<String?, String?> {
        return Pair("", "")
    }
}