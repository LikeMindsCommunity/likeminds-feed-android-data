package com.likeminds.likemindsfeed

import com.likeminds.internalsdk.branding.model._BrandingRequest_
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.likemindsfeed.branding.BrandingClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra
import com.likeminds.likemindsfeed.universalfeed.UniversalFeedClient
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LMFeedClient {

    @Inject
    lateinit var initiateUserClient: InitiateUserClient

    @Inject
    lateinit var brandingClient: BrandingClient

    @Inject
    lateinit var universalFeedClient: UniversalFeedClient

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
        val request =
            _InitiateUserRequest_.Builder().userId(initiateUserRequest.userId)
                .userName(initiateUserRequest.userName)
                .isGuest(initiateUserRequest.isGuest)
                .build()
        return initiateUserClient.initiateUser(request)
    }

    suspend fun getBranding(brandingRequest: BrandingRequest): BrandingResponse? {
        val request =
            _BrandingRequest_.Builder().communityId(brandingRequest.communityId)
                .build()
        return brandingClient.getBranding(request)
    }

    suspend fun getFeed(getFeedRequest: GetFeedRequest): GetFeedResponse? {
        val request = _GetFeedRequest_.Builder().page(getFeedRequest.page)
            .pageSize(getFeedRequest.pageSize)
            .build()
        return universalFeedClient.getFeed(request)
    }
}