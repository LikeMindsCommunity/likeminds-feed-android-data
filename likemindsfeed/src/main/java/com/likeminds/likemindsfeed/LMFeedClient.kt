package com.likeminds.likemindsfeed

import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra

class LMFeedClient private constructor() {

    companion object {
        @JvmStatic
        private var lmFeedClientInstance: LMFeedClient? = null

        fun build(extra: InitiateLikeMindsExtra): LMFeedClient {
            lmFeedClientInstance = LMFeedClient()
            val sdkApplication = LikeMindsFeedApplication.getInstance()
            sdkApplication.initSDKApplication(extra)
            sdkApplication.likeMindsFeedComponent?.inject(lmFeedClientInstance!!)
            return lmFeedClientInstance!!
        }

        fun getInstance(): LMFeedClient {
            if (lmFeedClientInstance == null) {
                lmFeedClientInstance = LMFeedClient()
            }
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