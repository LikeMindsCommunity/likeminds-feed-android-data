package com.likeminds.likemindsfeed

import android.app.Application
import androidx.annotation.Keep
import com.likeminds.likemindsfeed.comment.CommentClient
import com.likeminds.likemindsfeed.comment.model.AddCommentRequest
import com.likeminds.likemindsfeed.comment.model.AddCommentResponse
import com.likeminds.likemindsfeed.comment.model.DeleteCommentRequest
import com.likeminds.likemindsfeed.comment.model.EditCommentRequest
import com.likeminds.likemindsfeed.comment.model.EditCommentResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesRequest
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentRequest
import com.likeminds.likemindsfeed.comment.model.GetCommentResponse
import com.likeminds.likemindsfeed.comment.model.LikeCommentRequest
import com.likeminds.likemindsfeed.comment.model.ReplyCommentRequest
import com.likeminds.likemindsfeed.comment.model.ReplyCommentResponse
import com.likeminds.likemindsfeed.helper.HelperClient
import com.likeminds.likemindsfeed.helper.model.DecodeUrlRequest
import com.likeminds.likemindsfeed.helper.model.DecodeUrlResponse
import com.likeminds.likemindsfeed.helper.model.GetTaggingListRequest
import com.likeminds.likemindsfeed.helper.model.GetTaggingListResponse
import com.likeminds.likemindsfeed.helper.model.RegisterDeviceRequest
import com.likeminds.likemindsfeed.initiateUser.InitiateUserClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.LogoutRequest
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.moderation.ModerationClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.post.PostClient
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.AddPostResponse
import com.likeminds.likemindsfeed.post.model.DeletePostRequest
import com.likeminds.likemindsfeed.post.model.EditPostRequest
import com.likeminds.likemindsfeed.post.model.EditPostResponse
import com.likeminds.likemindsfeed.post.model.GetPostLikesRequest
import com.likeminds.likemindsfeed.post.model.GetPostLikesResponse
import com.likeminds.likemindsfeed.post.model.GetPostRequest
import com.likeminds.likemindsfeed.post.model.GetPostResponse
import com.likeminds.likemindsfeed.post.model.LikePostRequest
import com.likeminds.likemindsfeed.post.model.PinPostRequest
import com.likeminds.likemindsfeed.post.model.SavePostRequest
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.universalfeed.UniversalFeedClient
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Keep
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

    @Inject
    lateinit var helperClient: HelperClient

    class Builder(val application: Application) {

        private var lmCallback: LMCallback? = null

        fun lmCallback(lmCallback: LMCallback?) = apply { this.lmCallback = lmCallback }

        fun build(): LMFeedClient {
            lmFeedClientInstance = LMFeedClient()
            val sdkApplication = LikeMindsFeedApplication.getInstance()
            sdkApplication.initSDKApplication(application, lmCallback)
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

    // Exposed function to process logout request
    suspend fun logout(logoutRequest: LogoutRequest): LMResponse<Nothing> {
        return initiateUserClient.logout(logoutRequest)
    }

    // Exposed function to process member state
    suspend fun getMemberState(): LMResponse<MemberStateResponse> {
        return initiateUserClient.getMemberState()
    }

    suspend fun registerDevice(registerDeviceRequest: RegisterDeviceRequest): LMResponse<Nothing> {
        return helperClient.registerDevice(registerDeviceRequest)
    }

    // Exposed function to process feed request
    suspend fun getFeed(getFeedRequest: GetFeedRequest): LMResponse<GetFeedResponse> {
        return universalFeedClient.getFeed(getFeedRequest)
    }

    // Exposed function to process add post request
    suspend fun addPost(addPostRequest: AddPostRequest): LMResponse<AddPostResponse> {
        return postClient.addPost(addPostRequest)
    }

    // Exposed function to process edit post request
    suspend fun editPost(editPostRequest: EditPostRequest): LMResponse<EditPostResponse> {
        return postClient.editPost(editPostRequest)
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
    suspend fun addComment(addCommentRequest: AddCommentRequest): LMResponse<AddCommentResponse> {
        return commentClient.addComment(addCommentRequest)
    }

    // Exposed function to edit comment on the post
    suspend fun editComment(editCommentRequest: EditCommentRequest): LMResponse<EditCommentResponse> {
        return commentClient.editComment(editCommentRequest)
    }

    // Exposed function to add comment on the post
    suspend fun replyComment(replyCommentRequest: ReplyCommentRequest): LMResponse<ReplyCommentResponse> {
        return commentClient.replyComment(replyCommentRequest)
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

    // Exposed function to decode url and fetch ogTags
    suspend fun decodeUrl(decodeUrlRequest: DecodeUrlRequest): LMResponse<DecodeUrlResponse> {
        return helperClient.decodeUrl(decodeUrlRequest)
    }

    // Exposed function to fetch tagging list
    suspend fun getTaggingList(getTaggingListRequest: GetTaggingListRequest): LMResponse<GetTaggingListResponse> {
        return helperClient.getTaggingList(getTaggingListRequest)
    }
}