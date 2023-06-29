package com.likeminds.likemindsfeed.sdk

import com.likeminds.internalsdk.comment.model._AddCommentResponse_
import com.likeminds.internalsdk.comment.model._Comment_
import com.likeminds.internalsdk.comment.model._EditCommentResponse_
import com.likeminds.internalsdk.comment.model._GetCommentLikesResponse_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.comment.model._ReplyCommentResponse_
import com.likeminds.internalsdk.helper.model._DecodeUrlResponse_
import com.likeminds.internalsdk.helper.model._GetTaggingListResponse_
import com.likeminds.internalsdk.helper.model._TagMember_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.moderation.model._ReportTag_
import com.likeminds.internalsdk.notificationfeed.model._ActivityEntityData_
import com.likeminds.internalsdk.notificationfeed.model._Activity_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.notificationfeed.model._GetUnreadNotificationCountResponse_
import com.likeminds.internalsdk.post.model._AddPostResponse_
import com.likeminds.internalsdk.post.model._AttachmentMeta_
import com.likeminds.internalsdk.post.model._Attachment_
import com.likeminds.internalsdk.post.model._EditPostResponse_
import com.likeminds.internalsdk.post.model._GetPostLikesResponse_
import com.likeminds.internalsdk.post.model._GetPostResponse_
import com.likeminds.internalsdk.post.model._Like_
import com.likeminds.internalsdk.post.model._LinkOGTags_
import com.likeminds.internalsdk.post.model._MenuItem_
import com.likeminds.internalsdk.post.model._Post_
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._ManagementRightPermissionData_
import com.likeminds.internalsdk.sdk.model._MemberStateResponse_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.comment.model.AddCommentResponse
import com.likeminds.likemindsfeed.comment.model.Comment
import com.likeminds.likemindsfeed.comment.model.EditCommentResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentResponse
import com.likeminds.likemindsfeed.comment.model.ReplyCommentResponse
import com.likeminds.likemindsfeed.helper.model.DecodeUrlResponse
import com.likeminds.likemindsfeed.helper.model.GetTaggingListResponse
import com.likeminds.likemindsfeed.helper.model.TagMember
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.ManagementRightPermissionData
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.ReportTag
import com.likeminds.likemindsfeed.notificationfeed.model.Activity
import com.likeminds.likemindsfeed.notificationfeed.model.ActivityEntityData
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedResponse
import com.likeminds.likemindsfeed.notificationfeed.model.GetUnreadNotificationCountResponse
import com.likeminds.likemindsfeed.post.model.AddPostResponse
import com.likeminds.likemindsfeed.post.model.Attachment
import com.likeminds.likemindsfeed.post.model.AttachmentMeta
import com.likeminds.likemindsfeed.post.model.EditPostResponse
import com.likeminds.likemindsfeed.post.model.GetPostLikesResponse
import com.likeminds.likemindsfeed.post.model.GetPostResponse
import com.likeminds.likemindsfeed.post.model.Like
import com.likeminds.likemindsfeed.post.model.LinkOGTags
import com.likeminds.likemindsfeed.post.model.MenuItem
import com.likeminds.likemindsfeed.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse

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
        apiResponse: APIResponse<_MemberStateResponse_>
    ): LMResponse<MemberStateResponse> {
        return LMResponse(
            apiResponse.success,
            apiResponse.errorMessage,
            convertMemberStateResponse(apiResponse.data)
        )
    }

    // converts internal MemberStateResponse model to client model
    private fun convertMemberStateResponse(
        _memberStateResponse_: _MemberStateResponse_?
    ): MemberStateResponse? {
        val member = _memberStateResponse_?.member
        if (_memberStateResponse_ == null || member == null) return null
        return MemberStateResponse(
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
            convertUsersMap(_getFeedResponse_.users)
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
            convertUsersMap(_addPostResponse_.users)
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
            convertUsersMap(_editPostResponse_.users)
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
            convertUsersMap(_getPostResponse_.users)
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
        return Like(
            _like_.id,
            _like_.createdAt,
            _like_.updatedAt,
            _like_.userId,
        )
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
            convertTagMembers(_getTaggingListResponse_.members)
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
            convertUsersMap(_getNotificationFeedResponse_.users)
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

    // converts internal TagMember model list to client model list
    private fun convertTagMembers(
        _tagMembers_: List<_TagMember_>
    ): List<TagMember> {
        return _tagMembers_.map {
            convertTagMember(it)
        }
    }

    // converts internal TagMember model to client model
    private fun convertTagMember(
        _tagMember_: _TagMember_
    ): TagMember {
        return TagMember(
            _tagMember_.id,
            _tagMember_.imageUrl,
            _tagMember_.isGuest,
            _tagMember_.name,
            _tagMember_.userUniqueId,
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
        return Post(
            _post_.id,
            _post_.text,
            convertAttachments(_post_.attachments),
            _post_.communityId,
            _post_.isLiked,
            _post_.isEdited,
            _post_.isPinned,
            _post_.userId,
            _post_.likesCount,
            _post_.commentsCount,
            _post_.isSaved,
            convertMenuItems(_post_.menuItems),
            convertComments(_post_.replies),
            _post_.createdAt,
            _post_.updatedAt
        )
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
            .attachmentType(_attachment_.attachmentType)
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
        return Comment(
            _comment_.id,
            _comment_.isLiked,
            _comment_.isEdited,
            _comment_.userId,
            _comment_.text,
            _comment_.level,
            _comment_.likesCount,
            _comment_.commentsCount,
            _comment_.createdAt,
            _comment_.updatedAt,
            convertComments(_comment_.replies),
            convertMenuItems(_comment_.menuItems),
            _comment_.parentComment?.let { convertComment(it) },
        )
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
        return Activity(
            _activity_.id,
            _activity_.action,
            _activity_.actionBy,
            _activity_.actionOn,
            _activity_.activityText,
            _activity_.createdAt,
            _activity_.cta,
            _activity_.entityId,
            _activity_.entityOwnerId,
            _activity_.entityType,
            _activity_.isRead,
            _activity_.updatedAt,
            convertActivityEntityData(_activity_.activityEntityData)
        )
    }

    // converts internal ActivityEntityData model to client model
    private fun convertActivityEntityData(
        _activityEntityData_: _ActivityEntityData_?
    ): ActivityEntityData? {
        if (_activityEntityData_ == null) {
            return null
        }
        return ActivityEntityData(
            _activityEntityData_.id,
            _activityEntityData_.text,
            _activityEntityData_.deleteReason,
            _activityEntityData_.deletedBy,
            _activityEntityData_.heading,
            convertAttachments(_activityEntityData_.attachments),
            _activityEntityData_.communityId,
            _activityEntityData_.isEdited,
            _activityEntityData_.isPinned,
            _activityEntityData_.postId,
            _activityEntityData_.userId,
            convertComments(_activityEntityData_.replies),
            _activityEntityData_.level,
            _activityEntityData_.createdAt,
            _activityEntityData_.updatedAt,
        )
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
                .attachmentType(attachment.attachmentType)
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
}