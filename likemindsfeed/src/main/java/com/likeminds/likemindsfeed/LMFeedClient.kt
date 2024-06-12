package com.likeminds.likemindsfeed

import android.app.Application
import androidx.annotation.Keep
import com.likeminds.likemindsfeed.comment.CommentClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.configuration.ConfigurationClient
import com.likeminds.likemindsfeed.configuration.model.*
import com.likeminds.likemindsfeed.helper.HelperClient
import com.likeminds.likemindsfeed.helper.model.*
import com.likeminds.likemindsfeed.moderation.ModerationClient
import com.likeminds.likemindsfeed.moderation.model.*
import com.likeminds.likemindsfeed.notificationfeed.NotificationFeedClient
import com.likeminds.likemindsfeed.notificationfeed.model.*
import com.likeminds.likemindsfeed.poll.PollClient
import com.likeminds.likemindsfeed.poll.model.*
import com.likeminds.likemindsfeed.post.PostClient
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.topic.TopicClient
import com.likeminds.likemindsfeed.topic.model.GetTopicRequest
import com.likeminds.likemindsfeed.topic.model.GetTopicResponse
import com.likeminds.likemindsfeed.universalfeed.UniversalFeedClient
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import com.likeminds.likemindsfeed.user.UserClient
import com.likeminds.likemindsfeed.user.model.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Keep
class LMFeedClient private constructor() {
    @Inject
    lateinit var userClient: UserClient

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

    @Inject
    lateinit var notificationFeedClient: NotificationFeedClient

    @Inject
    lateinit var topicClient: TopicClient

    @Inject
    lateinit var configurationClient: ConfigurationClient

    @Inject
    lateinit var pollClient: PollClient

    @Keep
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

    @Keep
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
        return userClient.initiateUser(initiateUserRequest)
    }

    suspend fun validateUser(validateUserRequest: ValidateUserRequest): LMResponse<ValidateUserResponse> {
        return userClient.validateUser(validateUserRequest)
    }

    // Exposed function to process logout request
    suspend fun logout(logoutRequest: LogoutRequest): LMResponse<Nothing> {
        return userClient.logout(logoutRequest)
    }

    // Exposed function to process member state
    suspend fun getMemberState(): LMResponse<GetMemberStateResponse> {
        return userClient.getMemberState()
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

    // Exposed function to fetch notification feed
    suspend fun getNotificationFeed(getNotificationFeedRequest: GetNotificationFeedRequest): LMResponse<GetNotificationFeedResponse> {
        return notificationFeedClient.getNotificationFeed(getNotificationFeedRequest)
    }

    // Exposed function to fetch count of unread notifications
    suspend fun getUnreadNotificationCount(): LMResponse<GetUnreadNotificationCountResponse> {
        return notificationFeedClient.getUnreadNotificationCount()
    }

    // Exposed function to mark a notification as read
    suspend fun markReadNotification(markReadNotificationRequest: MarkReadNotificationRequest): LMResponse<Nothing> {
        return notificationFeedClient.markReadNotification(markReadNotificationRequest)
    }

    //Exposed function to get all topics
    suspend fun getTopics(getTopicRequest: GetTopicRequest): LMResponse<GetTopicResponse> {
        return topicClient.getTopics(getTopicRequest)
    }

    //Exposed function to get all community configurations
    suspend fun getCommunityConfigurations(): LMResponse<GetCommunityConfigurationsResponse> {
        return configurationClient.getCommunityConfigurations()
    }

    //Exposed function to get logged in user with rights
    suspend fun getLoggedInUserWithRights(): LMResponse<GetLoggedInUserWithRightsResponse> {
        return userClient.getLoggedInUserWithRights()
    }

    //Exposed function to get add temporary post in db
    suspend fun addTemporaryPost(addTemporaryPostRequest: AddTemporaryPostRequest): LMResponse<Nothing> {
        return postClient.addTemporaryPost(addTemporaryPostRequest)
    }

    //Exposed function to update the worker UUID of the post
    suspend fun updatePostWorkerUUID(uploadPostWorkerUUIDRequest: UpdatePostWorkerUUIDRequest): LMResponse<Nothing> {
        return postClient.updatePostWorkerUUID(uploadPostWorkerUUIDRequest)
    }

    //Exposed function to get current uploading post
    suspend fun getCurrentUploadingPost(): LMResponse<GetCurrentUploadingPostResponse> {
        return postClient.getCurrentUploadingPost()
    }

    // Exposed function to get temporary post using temporary id
    suspend fun getTemporaryPost(temporaryId: String): LMResponse<GetTemporaryPostResponse> {
        return postClient.getTemporaryPost(temporaryId)
    }

    //Exposed function to get community configuration using type
    suspend fun getCommunityConfiguration(request: GetCommunityConfigurationRequest): LMResponse<GetCommunityConfigurationResponse> {
        return configurationClient.getCommunityConfiguration(request)
    }

    //Exposed function to add poll option in a poll
    suspend fun addPollOption(addPollOptionRequest: AddPollOptionRequest): LMResponse<AddPollOptionResponse> {
        return pollClient.addPollOption(addPollOptionRequest)
    }

    //Exposed function to submit vote to a poll
    suspend fun submitVote(submitVoteRequest: SubmitVoteRequest): LMResponse<Nothing> {
        return pollClient.submitVote(submitVoteRequest)
    }

    //Exposed function to get result of the poll
    suspend fun getPollVotes(getPollVotesRequest: GetPollVotesRequest): LMResponse<GetPollVotesResponse> {
        return pollClient.getPollVotes(getPollVotesRequest)
    }
}