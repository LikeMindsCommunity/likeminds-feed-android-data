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

    override fun login() {
        Log.d("TAG---", "login: ")
    }

    override fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String) {
        Log.d(
            "PUI", """
               Core:
               onAccessTokenExpiredAndRefreshed
               accessToken: $accessToken
               refreshToken: $refreshToken
        """.trimIndent()
        )
    }

    override fun onRefreshTokenExpired(): Pair<String?, String?> {
        return runBlocking {
            Log.d("PUI", "Core: onRefreshTokenExpired")
            val initiateResponse = mFeedClient.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("4f881a74-8d0b-4c73-9f60-3d2370216392")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            if (initiateResponse.success) {
                val accessToken = initiateResponse.data?.accessToken
                val refreshToken = initiateResponse.data?.refreshToken
                Pair(accessToken, refreshToken)
            } else {
                Pair(null, null)
            }
        }
    }
}