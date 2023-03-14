package com.likeminds.likemindsfeed

import com.likeminds.likemindsfeed.branding.BrandingClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.comment.CommentClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.moderation.ModerationClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.moderation.model.PostReportResponse
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
    lateinit var commentClient: CommentClient

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

    // Exposed function to process initiate user request
    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): InitiateUserResponse {
        return initiateUserClient.initiateUser(initiateUserRequest)
    }

    // Exposed function to process branding request
    suspend fun getBranding(brandingRequest: BrandingRequest): BrandingResponse {
        return brandingClient.getBranding(brandingRequest)
    }

    // Exposed function to process feed request
    suspend fun getFeed(getFeedRequest: GetFeedRequest): GetFeedResponse {
        return universalFeedClient.getFeed(getFeedRequest)
    }

    // Exposed function to process add post request
    suspend fun addPost(addPostRequest: AddPostRequest): AddPostResponse {
        return postClient.addPost(addPostRequest)
    }

    // Exposed function to process fetch post request
    suspend fun getPost(getPostRequest: GetPostRequest): GetPostResponse {
        return postClient.getPost(getPostRequest)
    }

    // Exposed function to process request to fetch paginated likes on the post
    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): GetPostLikesResponse {
        return postClient.getPostLikes(getPostLikesRequest)
    }

    // Exposed function to process request to delete the post
    suspend fun deletePost(deletePostRequest: DeletePostRequest): DeletePostResponse {
        return postClient.deletePost(deletePostRequest)
    }

    // Exposed function to process request to like the post
    suspend fun likePost(likePostRequest: LikePostRequest): LikePostResponse {
        return postClient.likePost(likePostRequest)
    }

    // Exposed function to process request to save the post
    suspend fun savePost(savePostRequest: SavePostRequest): SavePostResponse {
        return postClient.savePost(savePostRequest)
    }

    // Exposed function to process request to pin the post
    suspend fun pinPost(pinPostRequest: PinPostRequest): PinPostResponse {
        return postClient.pinPost(pinPostRequest)
    }

    // Exposed function to process request to fetch report tags
    suspend fun getReportTags(getReportTagsRequest: GetReportTagsRequest): GetReportTagsResponse {
        return moderationClient.getReportTags(getReportTagsRequest)
    }

    // Exposed function to process request to post report on the entity
    suspend fun postReport(postReportRequest: PostReportRequest): PostReportResponse {
        return moderationClient.postReport(postReportRequest)
    }

    // Exposed function to add comment on the post
    suspend fun addComment(addCommentRequest: AddCommentRequest): AddCommentResponse {
        return commentClient.addComment(addCommentRequest)
    }

    // Exposed function to fetch the comment and its paginated replies
    suspend fun getComment(getCommentRequest: GetCommentRequest): GetCommentResponse {
        return commentClient.getComment(getCommentRequest)
    }

    // Exposed function to fetch likes data on the comment
    suspend fun getCommentLikes(getCommentLikesRequest: GetCommentLikesRequest): GetCommentLikesResponse {
        return commentClient.getCommentLikes(getCommentLikesRequest)
    }

    // Exposed function to like the comment
    suspend fun likeComment(likeCommentRequest: LikeCommentRequest): LikeCommentResponse {
        return commentClient.likeComment(likeCommentRequest)
    }

    // Exposed function to delete the comment
    suspend fun deleteComment(deleteCommentRequest: DeleteCommentRequest): DeleteCommentResponse {
        return commentClient.deleteComment(deleteCommentRequest)
    }
}