package com.likeminds.likemindsfeed.sdk

import android.net.Uri
import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.configuration.model._Configuration_
import com.likeminds.internalsdk.configuration.model._GetCommunityConfiguration_
import com.likeminds.internalsdk.db.model.*
import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.helper.model._GetTaggingListResponse_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.moderation.model._ReportTag_
import com.likeminds.internalsdk.notificationfeed.model.*
import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.sdk.model.*
import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.topic.model._Topic_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.widgets.model._LMMeta_
import com.likeminds.internalsdk.widgets.model._Widget_
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.configuration.model.*
import com.likeminds.likemindsfeed.configuration.util.ConfigurationUtil.getConfigurationType
import com.likeminds.likemindsfeed.helper.model.DecodeUrlResponse
import com.likeminds.likemindsfeed.helper.model.GetTaggingListResponse
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.ReportTag
import com.likeminds.likemindsfeed.notificationfeed.model.*
import com.likeminds.likemindsfeed.poll.model.*
import com.likeminds.likemindsfeed.poll.util.PollUtil.getPollMultiSelectStateValue
import com.likeminds.likemindsfeed.poll.util.PollUtil.getPollTypeValue
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.post.util.AttachmentUtil.getAttachmentType
import com.likeminds.likemindsfeed.post.util.AttachmentUtil.getAttachmentValue
import com.likeminds.likemindsfeed.sdk.model.*
import com.likeminds.likemindsfeed.topic.model.GetTopicResponse
import com.likeminds.likemindsfeed.topic.model.Topic
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import com.likeminds.likemindsfeed.user.model.*
import com.likeminds.likemindsfeed.widgets.model.LMMeta
import com.likeminds.likemindsfeed.widgets.model.Widget
import org.json.JSONObject

object ModelConverter {

    /**--------------------------------
     * Internal Model -> Client Model
    --------------------------------*/

    // converts api InitiateUserResponse model to LM InitiateUserResponse model
    fun convertInitiateUserResponse(
        apiResponse: APIResponse<_InitiateUserResponse_>
    ): LMResponse<InitiateUserResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertInitiateUserResponse(apiResponse.data)
        )
    }

    // converts internal InitiateUserResponse model to client model
    private fun convertInitiateUserResponse(
        _initiateUserResponse_: _InitiateUserResponse_?
    ): InitiateUserResponse? {
        if (_initiateUserResponse_ == null) return null
        return InitiateUserResponse(
            _initiateUserResponse_.accessToken,
            _initiateUserResponse_.refreshToken,
            convertUser(_initiateUserResponse_.user),
            convertCommunity(_initiateUserResponse_.community),
            _initiateUserResponse_.appAccess
        )
    }

    private fun convertUsers(users: List<_User_>): List<User> {
        return users.map { user ->
            convertUser(user)
        }
    }

    // converts internal User model to client model
    private fun convertUser(
        _user_: _User_
    ): User {
        return User.Builder()
            .id(_user_.id)
            .imageUrl(_user_.imageUrl)
            .isGuest(_user_.isGuest)
            .name(_user_.name)
            .organisationName(_user_.organisationName)
            .sdkClientInfo(convertSDKClientInfo(_user_.sdkClientInfo))
            .isDeleted(_user_.isDeleted)
            .customTitle(_user_.customTitle)
            .userUniqueId(_user_.userUniqueId)
            .uuid(_user_.uuid)
            .state(_user_.state)
            .customIntroText(_user_.customIntroText)
            .memberSince(_user_.memberSince)
            .questionAnswers(convertQuestionAnswers(_user_.questionAnswers))
            .build()
    }


    // converts the internal User model hashmap to client User Hashmap
    private fun convertUsersMap(
        _usersMap_: Map<String, _User_>
    ): Map<String, User> {
        val usersMap = _usersMap_.mapValues {
            convertUser(it.value)
        }
        return usersMap
    }

    // converts the internal Widgets model hashmap to client Widget Hashmap
    private fun convertWidgetsMap(
        _widgetsMap_: Map<String, _Widget_>
    ): Map<String, Widget> {
        val widgetsMap = _widgetsMap_.mapValues {
            convertWidget(it.value)
        }
        return widgetsMap
    }

    // converts the internal Topic model hashmap to client Topic Hashmap
    private fun convertTopicsMap(_topicsMap_: Map<String, _Topic_>): Map<String, Topic> {
        val topicsMap = _topicsMap_.mapValues {
            convertTopic(it.value)
        }
        return topicsMap
    }

    // converts the internal Widgets model to client Widget
    private fun convertWidget(
        _widget_: _Widget_
    ): Widget {
        return Widget.Builder()
            .id(_widget_.id)
            .createdAt(_widget_.createdAt)
            .metadata(JSONObject(_widget_.metadata.toString()))
            .parentEntityId(_widget_.parentEntityId)
            .parentEntityType(_widget_.parentEntityType)
            .updatedAt(_widget_.updatedAt)
            .lmMeta(convertLMMeta(_widget_.lmMeta))
            .build()
    }

    //converts the internal LMMeta model to client LMMeta
    private fun convertLMMeta(
        _lmMeta_: _LMMeta_?
    ): LMMeta? {
        if (_lmMeta_ == null) return null
        return LMMeta.Builder()
            .pollAnswerText(_lmMeta_.pollAnswerText)
            .toShowResults(_lmMeta_.toShowResults)
            .options(convertPollOptions(_lmMeta_.options))
            .build()
    }

    //converts the all internal PollOptions to client PollOptions
    private fun convertPollOptions(options: List<_PollOption_>?): List<PollOption>? {
        return options?.map {
            convertPollOption(it)
        }
    }

    //converts the internal PollOption model to client PollOption
    private fun convertPollOption(option: _PollOption_): PollOption {
        return PollOption.Builder()
            .id(option.id)
            .isSelected(option.isSelected)
            .uuid(option.uuid)
            .percentage(option.percentage)
            .voteCount(option.voteCount)
            .build()
    }


    // converts internal Community model to client model
    private fun convertCommunity(
        _community_: _Community_
    ): Community {
        return Community(
            _community_.id,
            _community_.name,
            _community_.imageUrl,
            _community_.membersCount,
            _community_.updatedAt,
        )
    }

    // converts internal SDKClientInfo model to client model
    private fun convertSDKClientInfo(
        _sdkClientInfo_: _SDKClientInfo_
    ): SDKClientInfo {
        return _sdkClientInfo_.let {
            SDKClientInfo.Builder()
                .uuid(it.uuid)
                .userUniqueId(it.userUniqueId)
                .user(it.user)
                .community(it.community)
                .build()
        }
    }

    // converts api MemberStateResponse model to LM MemberStateResponse model
    fun convertMemberStateResponse(
        apiResponse: APIResponse<_GetMemberStateResponse_>
    ): LMResponse<GetMemberStateResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertMemberStateResponse(apiResponse.data)
        )
    }

    // converts internal MemberStateResponse model to client model
    private fun convertMemberStateResponse(
        _memberStateResponse_: _GetMemberStateResponse_?
    ): GetMemberStateResponse? {
        val member = _memberStateResponse_?.member
        if (_memberStateResponse_ == null || member == null) return null
        return GetMemberStateResponse(
            member.id,
            _memberStateResponse_.state,
            member.userUniqueId,
            member.customTitle,
            member.imageUrl,
            member.isGuest,
            member.isOwner,
            member.name,
            member.organisationName,
            convertManagerRights(_memberStateResponse_.managerRights),
            convertMemberRights(_memberStateResponse_.memberRights),
            member.updatedAt,
            member.sdkClientInfo.uuid
        )
    }

    // converts internal ManagementRightPermissionData model list of manager rights to client model list
    private fun convertManagerRights(
        _rights_: List<_ManagementRightPermissionData_>?
    ): List<ManagementRightPermissionData>? {
        if (_rights_ == null) return null
        return _rights_.map {
            convertManagementRightPermission(it)
        }
    }

    // converts internal ManagementRightPermissionData model list of member rights client model list
    private fun convertMemberRights(
        _rights_: List<_ManagementRightPermissionData_>
    ): List<ManagementRightPermissionData> {
        return _rights_.map {
            convertManagementRightPermission(it)
        }
    }

    // converts internal ManagementRightPermissionData model to client model
    private fun convertManagementRightPermission(
        _right_: _ManagementRightPermissionData_
    ): ManagementRightPermissionData {
        return ManagementRightPermissionData(
            _right_.id,
            _right_.isLocked,
            _right_.isSelected,
            _right_.state,
            _right_.title,
            _right_.subtitle
        )
    }

    // converts api GetPostResponse model to LM GetPostResponse model
    fun convertGetFeedAPIResponse(
        apiResponse: APIResponse<_GetFeedResponse_>
    ): LMResponse<GetFeedResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetFeedResponse(apiResponse.data)
        )
    }

    // converts internal GetFeedResponse model to client model
    private fun convertGetFeedResponse(
        _getFeedResponse_: _GetFeedResponse_?
    ): GetFeedResponse? {
        if (_getFeedResponse_ == null) {
            return null
        }
        return GetFeedResponse(
            convertPosts(_getFeedResponse_.posts),
            convertUsersMap(_getFeedResponse_.users),
            convertWidgetsMap(_getFeedResponse_.widgets),
            convertTopicsMap(_getFeedResponse_.topics)
        )
    }

    // converts api AddPostResponse model to LM AddPostResponse model
    fun convertAddPostAPIResponse(
        apiResponse: APIResponse<_AddPostResponse_>
    ): LMResponse<AddPostResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertAddPostResponse(apiResponse.data)
        )
    }

    // converts internal AddPostResponse model to client model
    private fun convertAddPostResponse(
        _addPostResponse_: _AddPostResponse_?
    ): AddPostResponse? {
        if (_addPostResponse_ == null) {
            return null
        }
        return AddPostResponse(
            convertPost(_addPostResponse_.post),
            convertUsersMap(_addPostResponse_.users),
            convertWidgetsMap(_addPostResponse_.widgets),
            convertTopicsMap(_addPostResponse_.topics)
        )
    }

    // converts api EditPostResponse model to LM EditPostResponse model
    fun convertEditPostAPIResponse(
        apiResponse: APIResponse<_EditPostResponse_>
    ): LMResponse<EditPostResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertEditPostResponse(apiResponse.data)
        )
    }

    // converts internal EditPostResponse model to client model
    private fun convertEditPostResponse(
        _editPostResponse_: _EditPostResponse_?
    ): EditPostResponse? {
        if (_editPostResponse_ == null) {
            return null
        }
        return EditPostResponse(
            convertPost(_editPostResponse_.post),
            convertUsersMap(_editPostResponse_.users),
            convertWidgetsMap(_editPostResponse_.widgets),
            convertTopicsMap(_editPostResponse_.topics)
        )
    }

    // converts api GetPostResponse model to LM GetPostResponse model
    fun convertGetPostAPIResponse(
        apiResponse: APIResponse<_GetPostResponse_>
    ): LMResponse<GetPostResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetPostResponse(apiResponse.data)
        )
    }

    // converts internal GetPostResponse model to client model
    private fun convertGetPostResponse(
        _getPostResponse_: _GetPostResponse_?
    ): GetPostResponse? {
        if (_getPostResponse_ == null) {
            return null
        }
        return GetPostResponse(
            convertPost(_getPostResponse_.post),
            convertUsersMap(_getPostResponse_.users),
            convertWidgetsMap(_getPostResponse_.widgets),
            convertTopicsMap(_getPostResponse_.topics)
        )
    }

    // converts api GetPostResponse model to LM GetPostResponse model
    fun convertGetPostLikesAPIResponse(
        apiResponse: APIResponse<_GetPostLikesResponse_>
    ): LMResponse<GetPostLikesResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetPostLikesResponse(apiResponse.data)
        )
    }

    // converts internal GetPostLikesResponse model to client model
    private fun convertGetPostLikesResponse(
        _getPostLikesResponse_: _GetPostLikesResponse_?
    ): GetPostLikesResponse? {
        if (_getPostLikesResponse_ == null) {
            return null
        }
        return GetPostLikesResponse(
            convertLikes(_getPostLikesResponse_.likes),
            _getPostLikesResponse_.totalCount,
            convertUsersMap(_getPostLikesResponse_.users)
        )
    }

    // converts internal Like model list to client model list
    private fun convertLikes(
        _likes_: List<_Like_>
    ): List<Like> {
        return _likes_.map {
            convertLike(it)
        }
    }

    // converts internal Like model to client model
    private fun convertLike(
        _like_: _Like_
    ): Like {
        return Like.Builder()
            .id(_like_.id)
            .createdAt(_like_.createdAt)
            .updatedAt(_like_.updatedAt)
            .userId(_like_.userId)
            .uuid(_like_.uuid)
            .build()
    }

    // converts api AddCommentResponse model to LM AddCommentResponse model
    fun convertAddCommentAPIResponse(
        apiResponse: APIResponse<_AddCommentResponse_>
    ): LMResponse<AddCommentResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertAddCommentResponse(apiResponse.data)
        )
    }

    // converts internal AddCommentResponse model to client model
    private fun convertAddCommentResponse(
        _addCommentResponse_: _AddCommentResponse_?
    ): AddCommentResponse? {
        if (_addCommentResponse_ == null) {
            return null
        }
        return AddCommentResponse(
            convertComment(_addCommentResponse_.comment),
            convertUsersMap(_addCommentResponse_.users)
        )
    }

    // converts api EditCommentResponse model to LM EditCommentResponse model
    fun convertEditCommentAPIResponse(
        apiResponse: APIResponse<_EditCommentResponse_>
    ): LMResponse<EditCommentResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertEditCommentResponse(apiResponse.data)
        )
    }

    // converts internal EditCommentResponse model to client model
    private fun convertEditCommentResponse(
        _editCommentResponse_: _EditCommentResponse_?
    ): EditCommentResponse? {
        if (_editCommentResponse_ == null) {
            return null
        }
        return EditCommentResponse(
            convertComment(_editCommentResponse_.comment),
            convertUsersMap(_editCommentResponse_.users)
        )
    }

    // converts api ReplyCommentResponse model to LM ReplyCommentResponse model
    fun convertReplyCommentAPIResponse(
        apiResponse: APIResponse<_ReplyCommentResponse_>
    ): LMResponse<ReplyCommentResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertReplyCommentResponse(apiResponse.data)
        )
    }

    // converts internal ReplyCommentResponse model to client model
    private fun convertReplyCommentResponse(
        _addReplyComment_: _ReplyCommentResponse_?
    ): ReplyCommentResponse? {
        if (_addReplyComment_ == null) {
            return null
        }
        return ReplyCommentResponse(
            convertComment(_addReplyComment_.comment),
            convertUsersMap(_addReplyComment_.users)
        )
    }

    // converts api GetCommentResponse model to LM GetCommentResponse model
    fun convertGetCommentAPIResponse(
        apiResponse: APIResponse<_GetCommentResponse_>
    ): LMResponse<GetCommentResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetCommentResponse(apiResponse.data)
        )
    }

    // converts internal GetCommentResponse model to client model
    private fun convertGetCommentResponse(
        _getCommentResponse_: _GetCommentResponse_?
    ): GetCommentResponse? {
        if (_getCommentResponse_ == null) {
            return null
        }
        return GetCommentResponse(
            convertComment(_getCommentResponse_.comment),
            convertUsersMap(_getCommentResponse_.users)
        )
    }

    // converts api GetCommentLikesResponse model to LM GetCommentResponse model
    fun convertGetCommentLikesAPIResponse(
        apiResponse: APIResponse<_GetCommentLikesResponse_>
    ): LMResponse<GetCommentLikesResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetCommentLikesResponse(apiResponse.data)
        )
    }

    // converts internal GetCommentLikesResponse model to client model
    private fun convertGetCommentLikesResponse(
        _getCommentLikesResponse_: _GetCommentLikesResponse_?
    ): GetCommentLikesResponse? {
        if (_getCommentLikesResponse_ == null) return null
        return GetCommentLikesResponse(
            convertLikes(_getCommentLikesResponse_.likes),
            _getCommentLikesResponse_.totalCount,
            convertUsersMap(_getCommentLikesResponse_.users)
        )
    }

    // converts api GetReportTagsResponse model to LM GetReportTagsResponse model
    fun convertGetReportTagsAPIResponse(
        apiResponse: APIResponse<_GetReportTagsResponse_>
    ): LMResponse<GetReportTagsResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetReportTagsResponse(apiResponse.data)
        )
    }

    // converts internal GetReportTagsResponse model to client model
    private fun convertGetReportTagsResponse(
        _getReportTagsResponse_: _GetReportTagsResponse_?
    ): GetReportTagsResponse? {
        if (_getReportTagsResponse_ == null) {
            return null
        }
        return GetReportTagsResponse(
            convertReportTags(_getReportTagsResponse_.tags)
        )
    }

    // converts api DecodeUrlResponse model to LM DecodeUrlResponse model
    fun convertDecodeUrlResponse(
        apiResponse: APIResponse<_DecodeUrlResponse_>
    ): LMResponse<DecodeUrlResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertDecodeUrlResponse(apiResponse.data)
        )
    }

    // converts internal DecodeUrlResponse model to client model
    private fun convertDecodeUrlResponse(
        _decodeUrlResponse_: _DecodeUrlResponse_?
    ): DecodeUrlResponse? {
        if (_decodeUrlResponse_ == null) {
            return null
        }
        return DecodeUrlResponse(convertOGTags(_decodeUrlResponse_.ogTags))
    }

    // converts api GetTaggingListResponse model to LM GetTaggingListResponse model
    fun convertGetTaggingListAPIResponse(
        apiResponse: APIResponse<_GetTaggingListResponse_>
    ): LMResponse<GetTaggingListResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetTaggingListResponse(apiResponse.data)
        )
    }

    // converts internal GetTaggingListResponse model to client model
    private fun convertGetTaggingListResponse(
        _getTaggingListResponse_: _GetTaggingListResponse_?
    ): GetTaggingListResponse? {
        if (_getTaggingListResponse_ == null) {
            return null
        }
        return GetTaggingListResponse(
            convertUsers(_getTaggingListResponse_.members)
        )
    }

    // converts api GetNotificationFeedResponse model to LM GetNotificationFeedResponse model
    fun convertGetNotificationFeedAPIResponse(
        apiResponse: APIResponse<_GetNotificationFeedResponse_>
    ): LMResponse<GetNotificationFeedResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetNotificationFeedResponse(apiResponse.data)
        )
    }

    // converts internal GetNotificationFeedResponse model to client model
    private fun convertGetNotificationFeedResponse(
        _getNotificationFeedResponse_: _GetNotificationFeedResponse_?
    ): GetNotificationFeedResponse? {
        if (_getNotificationFeedResponse_ == null) {
            return null
        }
        return GetNotificationFeedResponse(
            convertActivities(_getNotificationFeedResponse_.activities),
            convertUsersMap(_getNotificationFeedResponse_.users),
            convertWidgetsMap(_getNotificationFeedResponse_.widgets),
            convertTopicsMap(_getNotificationFeedResponse_.topics)
        )
    }

    // converts api GetUnreadNotificationCountResponse model to LM GetUnreadNotificationCountResponse model
    fun convertGetUnreadNotificationCountAPIResponse(
        apiResponse: APIResponse<_GetUnreadNotificationCountResponse_>
    ): LMResponse<GetUnreadNotificationCountResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetUnreadNotificationCountResponse(apiResponse.data)
        )
    }

    // converts internal GetNotificationFeedResponse model to client model
    private fun convertGetUnreadNotificationCountResponse(
        _getUnreadNotificationCountResponse_: _GetUnreadNotificationCountResponse_?
    ): GetUnreadNotificationCountResponse? {
        if (_getUnreadNotificationCountResponse_ == null) {
            return null
        }
        return GetUnreadNotificationCountResponse(
            _getUnreadNotificationCountResponse_.count
        )
    }

    // converts internal ReportTag model list to client model list
    private fun convertReportTags(
        _tags_: List<_ReportTag_>
    ): List<ReportTag> {
        return _tags_.map {
            convertReportTag(it)
        }
    }

    // converts internal ReportTag model to client model
    private fun convertReportTag(
        _reportTag_: _ReportTag_
    ): ReportTag {
        return ReportTag(
            _reportTag_.id,
            _reportTag_.name
        )
    }

    // converts internal Post model list to client model list
    private fun convertPosts(
        _posts_: List<_Post_>
    ): List<Post> {
        return _posts_.map {
            convertPost(it)
        }
    }

    // converts internal Post model to client model
    private fun convertPost(
        _post_: _Post_
    ): Post {
        return Post.Builder()
            .id(_post_.id)
            .text(_post_.text)
            .attachments(convertAttachments(_post_.attachments))
            .communityId(_post_.communityId)
            .isLiked(_post_.isLiked)
            .isEdited(_post_.isEdited)
            .isPinned(_post_.isPinned)
            .userId(_post_.userId)
            .likesCount(_post_.likesCount)
            .commentCount(_post_.commentsCount)
            .isSaved(_post_.isSaved)
            .menuItems(convertMenuItems(_post_.menuItems))
            .replies(convertComments(_post_.replies))
            .createdAt(_post_.createdAt)
            .updatedAt(_post_.updatedAt)
            .uuid(_post_.uuid)
            .heading(_post_.heading)
            .tempId(_post_.tempId)
            .topicIds(_post_.topicIds)
            .build()
    }

    // converts internal Attachment model list to client model list
    private fun convertAttachments(
        _attachments_: List<_Attachment_>?
    ): List<Attachment>? {
        if (_attachments_ == null) return null
        return _attachments_.map {
            convertAttachment(it)
        }
    }

    // converts internal Attachment model to client model
    private fun convertAttachment(
        _attachment_: _Attachment_
    ): Attachment {
        return Attachment.Builder()
            .attachmentType(_attachment_.attachmentType.getAttachmentType())
            .attachmentMeta(convertAttachmentMeta(_attachment_.attachmentMeta))
            .build()
    }

    // converts internal AttachmentMeta model to client model
    private fun convertAttachmentMeta(
        _attachmentMeta_: _AttachmentMeta_
    ): AttachmentMeta {
        return AttachmentMeta.Builder()
            .name(_attachmentMeta_.name)
            .url(_attachmentMeta_.url)
            .format(_attachmentMeta_.format)
            .size(_attachmentMeta_.size)
            .duration(_attachmentMeta_.duration)
            .pageCount(_attachmentMeta_.pageCount)
            .ogTags(convertOGTags(_attachmentMeta_.ogTags))
            .coverImageUrl(_attachmentMeta_.coverImageUrl)
            .title(_attachmentMeta_.title)
            .body(_attachmentMeta_.body)
            .entityId(_attachmentMeta_.entityId)
            .thumbnailUrl(_attachmentMeta_.thumbnailUrl)
            .build()
    }

    // converts internal LinkOGTags model to client model
    private fun convertOGTags(
        _ogTags_: _LinkOGTags_
    ): LinkOGTags {
        return LinkOGTags.Builder()
            .title(_ogTags_.title)
            .image(_ogTags_.image)
            .description(_ogTags_.description)
            .url(_ogTags_.url)
            .build()
    }

    // converts internal Comment model list to client model list
    private fun convertComments(
        _comments_: List<_Comment_>?
    ): List<Comment>? {
        if (_comments_ == null) return null
        return _comments_.map {
            convertComment(it)
        }
    }

    // converts internal Comment model to client model
    private fun convertComment(
        _comment_: _Comment_
    ): Comment {
        return Comment.Builder()
            .id(_comment_.id)
            .isLiked(_comment_.isLiked)
            .isEdited(_comment_.isEdited)
            .userId(_comment_.userId)
            .text(_comment_.text)
            .level(_comment_.level)
            .likesCount(_comment_.likesCount)
            .commentsCount(_comment_.commentsCount)
            .createdAt(_comment_.createdAt)
            .updatedAt(_comment_.updatedAt)
            .replies(convertComments(_comment_.replies))
            .menuItems(convertMenuItems(_comment_.menuItems))
            .parentComment(_comment_.parentComment?.let { convertComment(it) })
            .uuid(_comment_.uuid)
            .tempId(_comment_.tempId)
            .build()
    }

    // converts internal MenuItem model list to client model list
    private fun convertMenuItems(
        _menuItems_: List<_MenuItem_>
    ): List<MenuItem> {
        return _menuItems_.map {
            convertMenuItem(it)
        }
    }

    // converts internal MenuItem model to client model
    private fun convertMenuItem(
        _menuItem_: _MenuItem_
    ): MenuItem {
        return MenuItem(
            _menuItem_.id,
            _menuItem_.title
        )
    }

    // converts internal Activity model list to client model list
    private fun convertActivities(
        _activities_: List<_Activity_>
    ): List<Activity> {
        return _activities_.map {
            convertActivity(it)
        }
    }

    // converts internal Activity model to client model
    private fun convertActivity(
        _activity_: _Activity_
    ): Activity {
        return Activity.Builder()
            .id(_activity_.id)
            .action(_activity_.action)
            .actionBy(_activity_.actionBy)
            .actionOn(_activity_.actionOn)
            .activityText(_activity_.activityText)
            .createdAt(_activity_.createdAt)
            .cta(_activity_.cta)
            .entityId(_activity_.entityId)
            .entityOwnerId(_activity_.entityOwnerId)
            .entityType(_activity_.entityType)
            .isRead(_activity_.isRead)
            .updatedAt(_activity_.updatedAt)
            .activityEntityData(convertActivityEntityData(_activity_.activityEntityData))
            .uuid(_activity_.uuid)
            .build()
    }

    // converts internal ActivityEntityData model to client model
    private fun convertActivityEntityData(
        _activityEntityData_: _ActivityEntityData_?
    ): ActivityEntityData? {
        if (_activityEntityData_ == null) {
            return null
        }
        return ActivityEntityData.Builder()
            .id(_activityEntityData_.id)
            .text(_activityEntityData_.text)
            .deleteReason(_activityEntityData_.deleteReason)
            .deletedBy(_activityEntityData_.deletedBy)
            .heading(_activityEntityData_.heading)
            .attachments(convertAttachments(_activityEntityData_.attachments))
            .communityId(_activityEntityData_.communityId)
            .isEdited(_activityEntityData_.isEdited)
            .isPinned(_activityEntityData_.isPinned)
            .postId(_activityEntityData_.postId)
            .userId(_activityEntityData_.userId)
            .replies(convertComments(_activityEntityData_.replies))
            .level(_activityEntityData_.level)
            .createdAt(_activityEntityData_.createdAt)
            .updatedAt(_activityEntityData_.updatedAt)
            .uuid(_activityEntityData_.uuid)
            .deletedByUUID(_activityEntityData_.deletedByUUID)
            .build()
    }

    // converts internal QuestionAnswer model list to client model list
    private fun convertQuestionAnswers(
        _questionAnswers_: List<_QuestionAnswer_>?
    ): List<QuestionAnswer>? {
        if (_questionAnswers_ == null) {
            return null
        }
        return _questionAnswers_.map {
            convertQuestionAnswer(it)
        }
    }

    // converts internal QuestionAnswer model to client model
    private fun convertQuestionAnswer(
        _questionAnswer_: _QuestionAnswer_
    ): QuestionAnswer {
        return QuestionAnswer(
            convertAnswer(_questionAnswer_.answer),
            convertQuestion(_questionAnswer_.question)
        )
    }

    // converts internal Question model to client model
    private fun convertQuestion(
        _question_: _Question_
    ): Question {
        return Question.Builder()
            .id(_question_.id)
            .questionTitle(_question_.questionTitle)
            .state(_question_.state)
            .value(_question_.value)
            .optional(_question_.optional)
            .helpText(_question_.helpText)
            .field(_question_.field)
            .isCompulsory(_question_.isCompulsory)
            .isHidden(_question_.isHidden)
            .communityId(_question_.communityId)
            .memberId(_question_.memberId)
            .directoryFields(_question_.directoryFields)
            .imageUrl(_question_.imageUrl)
            .canAddOtherOptions(_question_.canAddOtherOptions)
            .isAnswerEditable(_question_.isAnswerEditable)
            .questionChangeState(_question_.questionChangeState)
            .tag(_question_.tag)
            .rank(_question_.rank)
            .build()
    }

    // converts internal Answer model to client model
    private fun convertAnswer(
        _answer_: _Answer_
    ): Answer {
        return Answer.Builder()
            .answer(_answer_.answer)
            .memberId(_answer_.memberId)
            .questionId(_answer_.questionId)
            .communityId(_answer_.communityId)
            .imageUrl(_answer_.imageUrl)
            .build()
    }

    // converts API _GetTopicsResponse_ to LM GetTopicResponse model
    fun convertGetTopicsAPIResponse(
        apiResponse: APIResponse<_GetTopicsResponse_>
    ): LMResponse<GetTopicResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetTopicsResponse(apiResponse.data)
        )
    }

    // converts internal _GetTopicsResponse_ to client GetTopicResponse model
    private fun convertGetTopicsResponse(_getTopicsResponse_: _GetTopicsResponse_?): GetTopicResponse? {
        if (_getTopicsResponse_ == null) return null
        return GetTopicResponse(
            _getTopicsResponse_.topics.map { _topic_ ->
                convertTopic(_topic_)
            }
        )
    }

    // converts internal topic to client topic model
    private fun convertTopic(_topic_: _Topic_): Topic {
        return Topic.Builder()
            .id(_topic_.id)
            .isEnabled(_topic_.isEnabled)
            .name(_topic_.name)
            .build()
    }

    // converts APIResponse<_GetCommunityConfiguration_> to LMResponse<GetCommunityConfiguration> model
    fun convertGetCommunityConfigurationAPIResponse(
        apiResponse: APIResponse<_GetCommunityConfiguration_>
    ): LMResponse<GetCommunityConfigurationsResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetCommunityConfiguration(apiResponse.data)
        )
    }

    // converts internal _GetCommunityConfiguration_ to client GetCommunityConfiguration
    private fun convertGetCommunityConfiguration(_getCommunityConfiguration_: _GetCommunityConfiguration_?): GetCommunityConfigurationsResponse? {
        if (_getCommunityConfiguration_ == null) {
            return null
        }
        return GetCommunityConfigurationsResponse(
            _getCommunityConfiguration_.configurations.map { _configuration_ ->
                convertConfiguration(_configuration_)
            }
        )
    }

    // converts internal _Configuration_ to client Configuration
    private fun convertConfiguration(_configuration_: _Configuration_): Configuration {
        val jsonString = _configuration_.value.toString()
        return Configuration.Builder()
            .type(_configuration_.type.getConfigurationType())
            .description(_configuration_.description)
            .value(JSONObject(jsonString))
            .build()
    }

    // converts APIResponse<_AddPollOptionResponse_> to LMResponse<AddPollOptionResponse>
    fun convertAddPollOptionAPIResponse(apiResponse: APIResponse<_AddPollOptionResponse_>): LMResponse<AddPollOptionResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertAddPollOptionResponse(apiResponse.data)
        )
    }

    // converts internal _AddPollOptionResponse_ to exposed AddPollOptionResponse
    private fun convertAddPollOptionResponse(_addPollOptionResponse_: _AddPollOptionResponse_?): AddPollOptionResponse? {
        if (_addPollOptionResponse_ == null) return null
        return AddPollOptionResponse(
            convertWidget(_addPollOptionResponse_.widget_)
        )
    }

    // converts APIResponse<_GetPollVotesResponse_> to LMResponse<GetPollVotesResponse>
    fun convertGetPollVotesAPIResponse(apiResponse: APIResponse<_GetPollVotesResponse_>): LMResponse<GetPollVotesResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertGetPollVotesResponse(apiResponse.data)
        )
    }

    // converts internal _GetPollVotesResponse_ to exposed GetPollVotesResponse
    private fun convertGetPollVotesResponse(data: _GetPollVotesResponse_?): GetPollVotesResponse? {
        if (data == null) return null
        return GetPollVotesResponse(
            convertPollVotes(data.votes),
            convertUsersMap(data.users),
            convertWidgetsMap(data.widgets)
        )
    }

    // converts list of internal _PollVote_ to list of exposed PollVote
    private fun convertPollVotes(votes: List<_PollVote_>): List<PollVote> {
        return votes.map { vote ->
            convertPollVote(vote)
        }
    }

    // converts internal _PollVote_ to exposed PollVote
    private fun convertPollVote(vote: _PollVote_): PollVote {
        return PollVote.Builder()
            .id(vote.id)
            .userIds(vote.userIds)
            .build()
    }

    /**--------------------------------
     * Client Model -> Internal Model
    --------------------------------*/

    // create a list of internal attachments from the client list
    fun createAttachments(
        attachments: List<Attachment>?
    ): List<_Attachment_>? {
        if (attachments == null) return null
        return attachments.map { attachment ->
            _Attachment_.Builder()
                .attachmentType(attachment.attachmentType.getAttachmentValue())
                .attachmentMeta(createAttachmentMeta(attachment.attachmentMeta))
                .build()
        }
    }

    // create a internal attachment meta from the meta provided by client
    private fun createAttachmentMeta(
        attachmentMeta: AttachmentMeta
    ): _AttachmentMeta_ {
        return _AttachmentMeta_.Builder()
            .name(attachmentMeta.name)
            .url(attachmentMeta.url)
            .format(attachmentMeta.format)
            .size(attachmentMeta.size)
            .duration(attachmentMeta.duration)
            .pageCount(attachmentMeta.pageCount)
            .ogTags(convertOGTags(attachmentMeta.ogTags))
            .coverImageUrl(attachmentMeta.coverImageUrl)
            .title(attachmentMeta.title)
            .body(attachmentMeta.body)
            .thumbnailUrl(attachmentMeta.thumbnailUrl)
            .expiryTime(attachmentMeta.expiryTime)
            .pollOptions(attachmentMeta.pollOptions)
            .multiSelectState(attachmentMeta.multiSelectState?.getPollMultiSelectStateValue())
            .pollType(attachmentMeta.pollType?.getPollTypeValue())
            .multiSelectNumber(attachmentMeta.multiSelectNumber)
            .isAnonymous(attachmentMeta.isAnonymous)
            .allowAddOption(attachmentMeta.allowAddOption)
            .build()
    }

    // converts client LinkOGTags model to internal model
    private fun convertOGTags(
        ogTags: LinkOGTags
    ): _LinkOGTags_ {
        return _LinkOGTags_.Builder()
            .title(ogTags.title)
            .image(ogTags.image)
            .description(ogTags.description)
            .url(ogTags.url)
            .build()
    }

    /**--------------------------------
     * Internal Model -> Db Model
    --------------------------------*/

    /**
     * converts [_User_] to [UserEntity]
     * @param user: object of [_User_]
     * @return object of [UserEntity]
     */
    fun createUserEntity(user: _User_): UserEntity {
        return UserEntity.Builder()
            .id(user.id)
            .imageUrl(user.imageUrl)
            .isGuest(user.isGuest)
            .name(user.name)
            .updatedAt(user.updatedAt)
            .customTitle(user.customTitle)
            .isDeleted(user.isDeleted)
            .userUniqueId(user.userUniqueId)
            .uuid(user.uuid)
            .sdkClientInfoEntity(createSDKClientInfoEntity(user.sdkClientInfo))
            .build()
    }

    /**
     * converts [_SDKClientInfo_] to [SDKClientInfoEntity]
     * @param sdkClientInfo: object of [_SDKClientInfo_]
     * @return object of [SDKClientInfoEntity]
     */
    private fun createSDKClientInfoEntity(sdkClientInfo: _SDKClientInfo_): SDKClientInfoEntity {
        return SDKClientInfoEntity.Builder()
            .user(sdkClientInfo.user)
            .community(sdkClientInfo.community)
            .userUniqueId(sdkClientInfo.userUniqueId)
            .uuid(sdkClientInfo.uuid)
            .build()
    }

    /**
     * converts list of [ManagementRightPermissionData] to list of [MemberRightsEntity]
     * @param userUniqueId: unique id of the user
     * @param memberRights: list of [_ManagementRightPermissionData_]
     * */
    fun createMemberRightsEntity(
        userUniqueId: String,
        memberRights: List<_ManagementRightPermissionData_>
    ): List<MemberRightsEntity> {
        return memberRights.map {
            createMemberRightEntity(
                userUniqueId,
                it
            )
        }
    }

    /**
     * converts [ManagementRightPermissionData] to [MemberRightsEntity]
     * @param userUniqueId: unique id of the user
     * @param memberRight: network model of member right [_ManagementRightPermissionData_]
     * */
    private fun createMemberRightEntity(
        userUniqueId: String,
        memberRight: _ManagementRightPermissionData_
    ): MemberRightsEntity {
        return MemberRightsEntity.Builder()
            .id(memberRight.id)
            .isLocked(memberRight.isLocked)
            .isSelected(memberRight.isSelected)
            .state(memberRight.state)
            .title(memberRight.title)
            .subtitle(memberRight.subtitle)
            .userUniqueId(userUniqueId)
            .build()
    }

    fun createConfigurationEntities(configurations: List<_Configuration_>): List<ConfigurationEntity> {
        return configurations.map { configuration ->
            createConfigurationEntity(configuration)
        }
    }

    private fun createConfigurationEntity(configuration: _Configuration_): ConfigurationEntity {
        val valueJSONString = configuration.value.toString()
        return ConfigurationEntity.Builder()
            .type(configuration.type)
            .value(valueJSONString)
            .description(configuration.description)
            .build()
    }

    /**--------------------------------
     * Client Model -> Db Model
    --------------------------------*/

    /**
     * converts [Post] to [PostEntity]
     * @param post: object of [Post]
     * @param thumbnail: Uri as String for thumbnail of the post
     * @param workerUUID: Upload worker UUID of the post
     */
    fun createPostEntity(post: Post, thumbnail: String?, workerUUID: String?): PostEntity {
        return PostEntity.Builder()
            .temporaryId(post.tempId ?: "-${System.currentTimeMillis()}")
            .postId(post.tempId.toString())
            .workerUUID(workerUUID ?: "")
            .thumbnail(thumbnail)
            .text(post.text)
            .isPosted(false)
            .build()
    }

    /**
     * converts list of [Attachment] to list of [AttachmentEntity]
     * @param attachments: list of [Attachment]
     * @param postTemporaryId: temporary id of post
     */
    fun createAttachmentEntities(
        postTemporaryId: String,
        attachments: List<Attachment>?
    ): List<AttachmentEntity> {
        if (attachments.isNullOrEmpty()) return emptyList()
        return attachments.map { attachment ->
            createAttachmentEntity(postTemporaryId, attachment)
        }
    }

    /**
     * converts [Attachment] to [AttachmentEntity]
     * @param attachment: object of [Attachment]
     * @param postTemporaryId: temporary id of post
     */
    private fun createAttachmentEntity(
        postTemporaryId: String,
        attachment: Attachment
    ): AttachmentEntity {
        return AttachmentEntity.Builder()
            .temporaryId(postTemporaryId)
            .postId(postTemporaryId)
            .attachmentType(attachment.attachmentType.getAttachmentValue())
            .attachmentMeta(createAttachmentMetaEntity(attachment.attachmentMeta))
            .build()
    }

    /**
     * converts [AttachmentMeta] to [AttachmentMetaEntity]
     * @param attachmentMeta: object of [AttachmentMeta]
     */
    private fun createAttachmentMetaEntity(attachmentMeta: AttachmentMeta): AttachmentMetaEntity {
        return AttachmentMetaEntity.Builder()
            .name(attachmentMeta.name)
            .url(attachmentMeta.url)
            .uri(attachmentMeta.localUri.toString())
            .pageCount(attachmentMeta.pageCount)
            .size(attachmentMeta.size)
            .duration(attachmentMeta.duration)
            .format(attachmentMeta.format)
            .awsFolderPath(attachmentMeta.awsFolderPath)
            .localFilePath(attachmentMeta.localFilePath)
            .thumbnailUrl(attachmentMeta.thumbnailUrl)
            .thumbnailAWSFolderPath(attachmentMeta.thumbnailAWSFolderPath)
            .thumbnailLocalFilePath(attachmentMeta.thumbnailLocalFilePath)
            .coverImageUrl(attachmentMeta.coverImageUrl)
            .body(attachmentMeta.body)
            .title(attachmentMeta.title)
            .entityId(attachmentMeta.entityId)
            .build()
    }

    /**
     * converts list of [Topic] to list of [TopicEntity]
     * @param topics: list of [Topic]
     * @param postTemporaryId: temporary id of post
     */
    fun createTopicEntities(postTemporaryId: String, topics: List<Topic>): List<TopicEntity> {
        return topics.map { topic ->
            createTopicEntity(postTemporaryId, topic)
        }
    }

    /**
     * converts [Topic] to [TopicEntity]
     * @param topic: object of [TopicEntity]
     * @param postTemporaryId: temporary id of post
     */
    private fun createTopicEntity(postTemporaryId: String, topic: Topic): TopicEntity {
        return TopicEntity.Builder()
            .id(topic.id)
            .isEnabled(topic.isEnabled)
            .name(topic.name)
            .postId(postTemporaryId)
            .build()
    }

    /**--------------------------------
     * Db Model -> Client Model
    --------------------------------*/

    /**
     * converts [UserWithRights] to [LMResponse] of [GetLoggedInUserWithRightsResponse]
     * @param userWithRights: object of [UserWithRights] from db
     * @return [LMResponse] of [GetLoggedInUserWithRightsResponse]
     * */
    fun convertGetLoggedInUserWithRightsResponse(
        userWithRights: UserWithRights
    ): LMResponse<GetLoggedInUserWithRightsResponse> {
        return LMResponse(
            success = true,
            data = convertUserWithRights(userWithRights)
        )
    }

    /**
     * converts [UserWithRights] to [GetLoggedInUserWithRightsResponse]
     * @param userWithRights: object of [UserWithRights] from db
     * @return [GetLoggedInUserWithRightsResponse]
     * */
    private fun convertUserWithRights(userWithRights: UserWithRights): GetLoggedInUserWithRightsResponse {
        return GetLoggedInUserWithRightsResponse(
            makeUser(userWithRights.user),
            makeUserRights(userWithRights.memberRights)
        )
    }

    /**
     * converts [UserEntity] to [User]
     * @param userEntity: object of [UserEntity] from db
     * @return [User]
     * */
    private fun makeUser(userEntity: UserEntity): User {
        return User.Builder()
            .id(userEntity.id)
            .imageUrl(userEntity.imageUrl)
            .isGuest(userEntity.isGuest)
            .name(userEntity.name)
            .sdkClientInfo(makeSDKClientInfo(userEntity.sdkClientInfoEntity))
            .isDeleted(userEntity.isDeleted)
            .customTitle(userEntity.customTitle)
            .updatedAt(userEntity.updatedAt)
            .userUniqueId(userEntity.userUniqueId)
            .uuid(userEntity.uuid)
            .state(userEntity.state)
            .build()
    }

    /**
     * converts [SDKClientInfoEntity] to [SDKClientInfo]
     * @param sdkClientInfoEntity: object of [SDKClientInfoEntity] from db
     * @return [SDKClientInfo]
     * */
    private fun makeSDKClientInfo(sdkClientInfoEntity: SDKClientInfoEntity): SDKClientInfo {
        return SDKClientInfo.Builder()
            .uuid(sdkClientInfoEntity.uuid)
            .user(sdkClientInfoEntity.user)
            .userUniqueId(sdkClientInfoEntity.userUniqueId)
            .community(sdkClientInfoEntity.community)
            .build()
    }

    /**
     * converts List of [MemberRightsEntity] to List of [ManagementRightPermissionData]
     * @param userRights: List of [MemberRightsEntity] from db
     * @return List of [ManagementRightPermissionData]
     * */
    private fun makeUserRights(userRights: List<MemberRightsEntity>): List<ManagementRightPermissionData> {
        return userRights.map { right ->
            makeUserRight(right)
        }
    }

    /**
     * converts [MemberRightsEntity] to [ManagementRightPermissionData]
     * @param right: object of [MemberRightsEntity] from db
     * @return [ManagementRightPermissionData]
     * */
    private fun makeUserRight(right: MemberRightsEntity): ManagementRightPermissionData {
        return ManagementRightPermissionData(
            id = right.id,
            isLocked = right.isLocked,
            isSelected = right.isSelected,
            state = right.state,
            title = right.title,
            subtitle = right.subtitle,
        )
    }

    /**
     * converts [PostWithAttachments] to [LMResponse] of [GetCurrentUploadingPostResponse]
     * @param postWithAttachments: object of [PostWithAttachments] from db
     * @return [LMResponse] of [GetCurrentUploadingPostResponse]
     * */
    fun convertGetCurrentUploadingPostResponse(postWithAttachments: PostWithAttachments): LMResponse<GetCurrentUploadingPostResponse> {
        return LMResponse(
            success = true,
            data = GetCurrentUploadingPostResponse(
                post = makePost(postWithAttachments),
                topics = makeTopics(postWithAttachments.topics)
            )
        )
    }

    /**
     * converts [PostWithAttachments] to [Post]
     * @param postWithAttachments: object of [PostWithAttachments] from db
     * @return [Post]
     * */
    private fun makePost(postWithAttachments: PostWithAttachments): Post {
        val postEntity = postWithAttachments.post
        val attachmentEntities = postWithAttachments.attachments
        return Post.Builder()
            .tempId(postEntity.temporaryId)
            .text(postEntity.text ?: "")
            .workerUUID(postEntity.workerUUID)
            .id(postEntity.postId)
            .attachments(makeAttachments(attachmentEntities))
            .isPosted(postEntity.isPosted)
            .build()
    }

    /**
     * converts List of [AttachmentEntity] to List of [Attachment]
     * @param attachmentEntities: List of [AttachmentEntity] from db
     * @return List of [Attachment]
     * */
    private fun makeAttachments(attachmentEntities: List<AttachmentEntity>): List<Attachment> {
        return attachmentEntities.map { attachment ->
            makeAttachment(attachment)
        }
    }

    /**
     * converts [AttachmentEntity] to [Attachment]
     * @param attachment: object of [AttachmentEntity] from db
     * @return [Attachment]
     * */
    private fun makeAttachment(attachment: AttachmentEntity): Attachment {
        return Attachment.Builder()
            .attachmentType(attachment.attachmentType.getAttachmentType())
            .attachmentMeta(makeAttachmentMeta(attachment.attachmentMeta))
            .build()
    }

    /**
     * converts [AttachmentMetaEntity] to [AttachmentMeta]
     * @param attachmentMeta: object of [AttachmentMetaEntity] from db
     * @return [AttachmentMeta]
     * */
    private fun makeAttachmentMeta(attachmentMeta: AttachmentMetaEntity): AttachmentMeta {
        return AttachmentMeta.Builder()
            .name(attachmentMeta.name)
            .url(attachmentMeta.url)
            .format(attachmentMeta.format)
            .size(attachmentMeta.size)
            .duration(attachmentMeta.duration)
            .pageCount(attachmentMeta.pageCount)
            .coverImageUrl(attachmentMeta.coverImageUrl)
            .title(attachmentMeta.title)
            .body(attachmentMeta.body)
            .entityId(attachmentMeta.entityId)
            .thumbnailUrl(attachmentMeta.thumbnailUrl)
            .awsFolderPath(attachmentMeta.awsFolderPath)
            .localFilePath(attachmentMeta.localFilePath)
            .localUri(Uri.parse(attachmentMeta.uri))
            .build()
    }

    /**
     * converts List of [TopicEntity] to List of [Topic]
     * @param topicsEntities: List of [TopicEntity] from db
     * @return List of [Topic]
     * */
    private fun makeTopics(topicsEntities: List<TopicEntity>): List<Topic> {
        return topicsEntities.map { topic ->
            makeTopic(topic)
        }
    }

    /**
     * converts [TopicEntity] to [Topic]
     * @param topic: object of [TopicEntity] from db
     * @return [Topic]
     * */
    private fun makeTopic(topic: TopicEntity): Topic {
        return Topic.Builder()
            .id(topic.id)
            .isEnabled(topic.isEnabled)
            .name(topic.name)
            .build()
    }

    fun convertGetTemporaryPostResponse(postWithAttachments: PostWithAttachments): LMResponse<GetTemporaryPostResponse> {
        return LMResponse(
            success = true,
            data = GetTemporaryPostResponse(
                post = makePost(postWithAttachments),
                topics = makeTopics(postWithAttachments.topics)
            )
        )
    }

    fun convertGetCommunityConfiguration(configurationEntity: ConfigurationEntity): LMResponse<GetCommunityConfigurationResponse> {
        return LMResponse(
            success = true,
            data = GetCommunityConfigurationResponse(
                configuration = makeConfiguration(configurationEntity)
            )
        )
    }

    private fun makeConfiguration(configurationEntity: ConfigurationEntity): Configuration {
        return Configuration.Builder()
            .description(configurationEntity.description)
            .value(JSONObject(configurationEntity.value))
            .type(configurationEntity.type.getConfigurationType())
            .build()
    }
}