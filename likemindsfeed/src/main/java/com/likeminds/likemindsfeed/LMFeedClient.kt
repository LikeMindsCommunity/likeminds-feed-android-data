package com.likeminds.likemindsfeed

import android.app.Application
import com.likeminds.likemindsfeed.comment.CommentClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.moderation.ModerationClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.post.PostClient
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.universalfeed.UniversalFeedClient
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LMFeedClient private constructor() {

    @Inject
    lateinit var initiateUserClient: InitiateUserClient

    @Inject
    lateinit var universalFeedClient: UniversalFeedClient

    @Inject
    lateinit var commentClient: CommentClient

    @Inject
    lateinit var postClient: PostClient

    @Inject
    lateinit var moderationClient: ModerationClient

    class Builder(val application: Application) {

        fun build(): LMFeedClient {
            lmFeedClientInstance = LMFeedClient()
            val sdkApplication = LikeMindsFeedApplication.getInstance()
            sdkApplication.initSDKApplication(application)
            sdkApplication.likeMindsFeedComponent?.inject(lmFeedClientInstance!!)
            return lmFeedClientInstance!!
        }
    }

    companion object {
        @JvmStatic
        private var lmFeedClientInstance: LMFeedClient? = null

        @JvmStatic
        fun getInstance(): LMFeedClient {
            if (lmFeedClientInstance == null) {
                throw IllegalAccessException("LMFeedClient not created, please call LMFeedClient.build()")
            }
            return lmFeedClientInstance!!
        }
    }

    // Exposed function to process initiate user request
    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): LMResponse<InitiateUserResponse> {
        return initiateUserClient.initiateUser(initiateUserRequest)
    }

    // Exposed function to process member state
    suspend fun memberState(): LMResponse<MemberStateResponse> {
        return initiateUserClient.memberState()
    }

    // Exposed function to process feed request
    suspend fun getFeed(getFeedRequest: GetFeedRequest): LMResponse<GetFeedResponse> {
        return universalFeedClient.getFeed(getFeedRequest)
    }

    // Exposed function to process add post request
    suspend fun addPost(addPostRequest: AddPostRequest): LMResponse<Nothing> {
        return postClient.addPost(addPostRequest)
    }

    // Exposed function to process fetch post request
    suspend fun getPost(getPostRequest: GetPostRequest): LMResponse<GetPostResponse> {
        return postClient.getPost(getPostRequest)
    }

    // Exposed function to process request to fetch paginated likes on the post
    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): LMResponse<GetPostLikesResponse> {
        return postClient.getPostLikes(getPostLikesRequest)
    }

    // Exposed function to process request to delete the post
    suspend fun deletePost(deletePostRequest: DeletePostRequest): LMResponse<Nothing> {
        return postClient.deletePost(deletePostRequest)
    }

    // Exposed function to process request to like the post
    suspend fun likePost(likePostRequest: LikePostRequest): LMResponse<Nothing> {
        return postClient.likePost(likePostRequest)
    }

    // Exposed function to process request to save the post
    suspend fun savePost(savePostRequest: SavePostRequest): LMResponse<Nothing> {
        return postClient.savePost(savePostRequest)
    }

    // Exposed function to process request to pin the post
    suspend fun pinPost(pinPostRequest: PinPostRequest): LMResponse<Nothing> {
        return postClient.pinPost(pinPostRequest)
    }

    // Exposed function to process request to fetch report tags
    suspend fun getReportTags(getReportTagsRequest: GetReportTagsRequest): LMResponse<GetReportTagsResponse> {
        return moderationClient.getReportTags(getReportTagsRequest)
    }

    // Exposed function to process request to post report on the entity
    suspend fun postReport(postReportRequest: PostReportRequest): LMResponse<Nothing> {
        return moderationClient.postReport(postReportRequest)
    }

    // Exposed function to add comment on the post
    suspend fun addComment(addCommentRequest: AddCommentRequest): LMResponse<Nothing> {
        return commentClient.addComment(addCommentRequest)
    }

    // Exposed function to add comment on the post
    suspend fun addReplyOnComment(addReplyOnCommentRequest: AddReplyOnCommentRequest): LMResponse<Nothing> {
        return commentClient.addReplyOnComment(addReplyOnCommentRequest)
    }

    // Exposed function to fetch the comment and its paginated replies
    suspend fun getComment(getCommentRequest: GetCommentRequest): LMResponse<GetCommentResponse> {
        return commentClient.getComment(getCommentRequest)
    }

    // Exposed function to fetch likes data on the comment
    suspend fun getCommentLikes(getCommentLikesRequest: GetCommentLikesRequest): LMResponse<GetCommentLikesResponse> {
        return commentClient.getCommentLikes(getCommentLikesRequest)
    }

    // Exposed function to like the comment
    suspend fun likeComment(likeCommentRequest: LikeCommentRequest): LMResponse<Nothing> {
        return commentClient.likeComment(likeCommentRequest)
    }

    // Exposed function to delete the comment
    suspend fun deleteComment(deleteCommentRequest: DeleteCommentRequest): LMResponse<Nothing> {
        return commentClient.deleteComment(deleteCommentRequest)
    }
}