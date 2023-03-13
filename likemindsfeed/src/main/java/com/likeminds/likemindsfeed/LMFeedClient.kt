package com.likeminds.likemindsfeed

import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LMFeedClient {

    @Inject
    lateinit var initiateUserClient: InitiateUserClient

    companion object {
        @JvmStatic
        private var lmFeedClientInstance: LMFeedClient? = null

        private lateinit var extras: InitiateLikeMindsExtra

        @JvmStatic
        fun build(extra: InitiateLikeMindsExtra): LMFeedClient {
            lmFeedClientInstance = LMFeedClient()
            extras = extra
            val sdkApplication = LikeMindsFeedApplication.getInstance()
            sdkApplication.initSDKApplication(extra)
            sdkApplication.likeMindsFeedComponent?.inject(lmFeedClientInstance!!)
            return lmFeedClientInstance!!
        }

        @JvmStatic
        fun getInstance(): LMFeedClient {
            if (lmFeedClientInstance == null) {
                throw IllegalAccessException("LMFeedClient not created, please call LMFeedClient.build()")
            }
            return lmFeedClientInstance!!
        }
    }

    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): InitiateUserResponse? {
        return initiateUserClient.initiateUser(initiateUserRequest)
    }
}