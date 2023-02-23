package com.likeminds.likemindsfeed

import com.likeminds.likemindsfeed.branding.BrandingClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.moderation.ModerationClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.post.PostClient
import com.likeminds.likemindsfeed.post.model.*
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

    @Inject
    lateinit var postClient: PostClient

    @Inject
    lateinit var moderationClient: ModerationClient

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

    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): InitiateUserResponse {
        return initiateUserClient.initiateUser(initiateUserRequest)
    }

    suspend fun getBranding(brandingRequest: BrandingRequest): BrandingResponse {
        return brandingClient.getBranding(brandingRequest)
    }

    suspend fun getFeed(getFeedRequest: GetFeedRequest): GetFeedResponse {
        return universalFeedClient.getFeed(getFeedRequest)
    }

    suspend fun addPost(addPostRequest: AddPostRequest): AddPostResponse {
        return postClient.addPost(addPostRequest)
    }

    suspend fun getPost(getPostRequest: GetPostRequest): GetPostResponse {
        return postClient.getPost(getPostRequest)
    }

    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): GetPostLikesResponse {
        return postClient.getPostLikes(getPostLikesRequest)
    }

    suspend fun deletePost(deletePostRequest: DeletePostRequest): DeletePostResponse {
        return postClient.deletePost(deletePostRequest)
    }

    suspend fun likePost(likePostRequest: LikePostRequest): LikePostResponse {
        return postClient.likePost(likePostRequest)
    }

    suspend fun savePost(savePostRequest: SavePostRequest): SavePostResponse {
        return postClient.savePost(savePostRequest)
    }

    suspend fun pinPost(pinPostRequest: PinPostRequest): PinPostResponse {
        return postClient.pinPost(pinPostRequest)
    }

    suspend fun getReportTags(getReportTagsRequest: GetReportTagsRequest): GetReportTagsResponse {
        return moderationClient.getReportTags(getReportTagsRequest)
    }
}