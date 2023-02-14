package com.likeminds.likemindsfeed

import android.util.Log
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra
import javax.inject.Singleton

@Singleton
class LMFeedClient {

    companion object {
        @JvmStatic
        private var lmFeedClientInstance: LMFeedClient? = null

        private lateinit var extras:InitiateLikeMindsExtra

        @JvmStatic
        fun build(extra: InitiateLikeMindsExtra): LMFeedClient {
            lmFeedClientInstance = LMFeedClient()
            extras = extra
            Log.d("PUI","client instance 2: $lmFeedClientInstance")
            val sdkApplication = LikeMindsFeedApplication.getInstance()
            sdkApplication.initSDKApplication(extra)
            sdkApplication.likeMindsFeedComponent?.inject(lmFeedClientInstance!!)
            return lmFeedClientInstance!!
        }

        @JvmStatic
        fun getInstance(): LMFeedClient {
            Log.d("PUI","client instance: $lmFeedClientInstance")
            if (lmFeedClientInstance == null) {
                lmFeedClientInstance = build(extras)
            }
            Log.d("PUI","client instance: $lmFeedClientInstance")
            return lmFeedClientInstance!!
        }
    }

    suspend fun initiateUser(): Boolean {
        val initiateUserClient = InitiateUserClient.getInstance()
        val request =
            _InitiateUserRequest_.Builder().userId("10003").userName("Ishaan").isGuest(false)
                .build()
        return initiateUserClient.initiateUser(request)
    }

}