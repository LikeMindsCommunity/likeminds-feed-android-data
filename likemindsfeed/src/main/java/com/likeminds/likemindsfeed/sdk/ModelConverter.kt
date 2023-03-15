package com.likeminds.likemindsfeed.sdk

import android.content.Context
import androidx.core.net.toUri
import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.comment.model._GetCommentLikesResponse_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.moderation.model._ReportTag_
import com.likeminds.internalsdk.post.model._GetPostLikesResponse_
import com.likeminds.internalsdk.post.model._GetPostResponse_
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.sdk.utils.FileUtils.generateAWSFolderPathFromFilePath
import com.likeminds.likemindsfeed.sdk.utils.FileUtils.generateUrlFromAWSFolderPath
import com.likeminds.likemindsfeed.sdk.utils.FileUtils.getFileNameFromPath
import com.likeminds.likemindsfeed.sdk.utils.FileUtils.getRealPath
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.ReportTag
import com.likeminds.likemindsfeed.post.model.GetPostLikesResponse
import com.likeminds.likemindsfeed.post.model.GetPostResponse
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse

object ModelConverter {

    /**--------------------------------
     * Internal Model -> Client Model
    --------------------------------*/

    // converts api InitiateUserResponse model to LM InitiateUserResponse model
    fun convertInitiateUserResponse(
        _initiateUserResponse_: APIResponse<_InitiateUserResponse_>
    ): LMResponse<InitiateUserResponse> {
        return LMResponse(
            _initiateUserResponse_.success,
            _initiateUserResponse_.errorMessage,
            InitiateUserResponse(
                _initiateUserResponse_.data?.appAccess,
                convertInitiateUser(
                    _initiateUserResponse_.data?.user!!,
                    _initiateUserResponse_.data?.community!!
                )
            )
        )
    }

    // converts internal InitiateUser model to client model
    fun convertInitiateUser(
        _user_: _User_,
        _community_: _Community_
    ): InitiateUser {
        return InitiateUser(
            convertUser(_user_),
            convertCommunity(_community_)
        )
    }

    // converts internal User model to client model
    fun convertUser(
        _user_: _User_
    ): User {
        return User(
            _user_.id,
            _user_.imageUrl,
            _user_.isGuest,
            _user_.name,
            _user_.organisationName,
            convertSDKClientInfo(_user_.sdkClientInfo),
            _user_.updatedAt,
            _user_.userUniqueId
        )
    }

    // converts the internal User model hashmap to client User Hashmap
    fun convertUsersMap(
        _usersMap_: Map<String, _User_>
    ): Map<String, User> {
        val usersMap = _usersMap_.mapValues {
            convertUser(it.value)
        }
        return usersMap
    }

    // converts internal Community model to client model
    fun convertCommunity(
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
    fun convertSDKClientInfo(
        _sdkClientInfo_: _SDKClientInfo_?
    ): SDKClientInfo? {
        return _sdkClientInfo_?.let {
            SDKClientInfo(
                it.community,
                it.user,
                it.userUniqueId
            )
        }
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
    fun convertGetFeedResponse(
        _getFeedResponse_: _GetFeedResponse_?
    ): GetFeedResponse? {
        if (_getFeedResponse_ == null) {
            return null
        }
        return GetFeedResponse(
        convertPostsList(_getFeedResponse_.posts),
            convertUsersMap(_getFeedResponse_.users)
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
    fun convertGetPostResponse(
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
    fun convertGetPostLikesResponse(
        _getPostLikesResponse_: _GetPostLikesResponse_?
    ): GetPostLikesResponse? {
        if (_getPostLikesResponse_ == null) {
            return null
        }
        return GetPostLikesResponse(
            _getPostLikesResponse_.likes,
            _getPostLikesResponse_.totalCount,
            convertUsersMap(_getPostLikesResponse_.users)
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
    fun convertGetCommentResponse(
        _getCommentResponse_: _GetCommentResponse_?
    ): GetCommentResponse? {
        if (_getCommentResponse_ == null) {
            return null
        }
        return GetCommentResponse(
            _getCommentResponse_.comment,
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
    fun convertGetCommentLikesResponse(
        _getCommentLikesResponse_: _GetCommentLikesResponse_?
    ): GetCommentLikesResponse? {
        if (_getCommentLikesResponse_ == null) return null
        return GetCommentLikesResponse(
            _getCommentLikesResponse_.likes,
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
    fun convertGetReportTagsResponse(
        _getReportTagsResponse_: _GetReportTagsResponse_?
    ): GetReportTagsResponse? {
        if (_getReportTagsResponse_ == null) {
            return null
        }
        return GetReportTagsResponse(
            convertReportTagsList(_getReportTagsResponse_.tags)
        )
    }

    // converts internal ReportTag model list to client model list
    fun convertReportTagsList(
        _tags_: List<_ReportTag_>
    ): List<ReportTag> {
        val posts = mutableListOf<ReportTag>()
        _tags_.forEach {
            posts.add(convertReportTag(it))
        }
        return posts
    }

    // converts internal ReportTag model to client model
    fun convertReportTag(
        _reportTag_: _ReportTag_
    ): ReportTag {
        return ReportTag(
            _reportTag_.id,
            _reportTag_.name
        )
    }

    fun convertPostsList(
        _posts_: List<_Post_>
    ): List<Post> {
        val posts = mutableListOf<Post>()
        _posts_.forEach {
            posts.add(convertPost(it))
        }
        return posts
    }

    fun convertPost(
        _post_: _Post_
    ): Post {
        return Post.Builder().id(_post_.id)
            .text(_post_.text)
            .attachments(convertAttachmentsList(_post_.attachments))
            .communityId(_post_.communityId)
            .isLiked(_post_.isLiked)
            .isPinned(_post_.isPinned)
            .userId(_post_.userId)
            .likesCount(_post_.likesCount)
            .commentsCount(_post_.commentsCount)
            .isSaved(_post_.isSaved)
            .menuItems(convertMenuItemsList(_post_.menuItems))
            .replies(convertCommentsList(_post_.replies))
            .createdAt(_post_.createdAt)
            .updatedAt(_post_.updatedAt)
            .build()
    }

    fun convertAttachmentsList(
        _attachments_: List<_Attachment_>?
    ): List<Attachment>? {
        if (_attachments_ == null) return null
        val attachments = mutableListOf<Attachment>()
        _attachments_.forEach {
            attachments.add(convertAttachment(it))
        }
        return attachments
    }

    fun convertAttachment(
        _attachment_: _Attachment_
    ): Attachment {
        return Attachment.Builder()
            .attachmentType(_attachment_.attachmentType)
            .attachmentMeta(convertAttachmentMeta(_attachment_.attachmentMeta))
            .build()
    }

    fun convertAttachmentMeta(
        _attachmentMeta_: _AttachmentMeta_?
    ): AttachmentMeta? {
        if (_attachmentMeta_ == null) return null
        return AttachmentMeta.Builder()
            .name(_attachmentMeta_.name)
            .url(_attachmentMeta_.url)
            .format(_attachmentMeta_.format)
            .size(_attachmentMeta_.size)
            .duration(_attachmentMeta_.duration)
            .pageCount(_attachmentMeta_.pageCount)
            .ogTags(convertOGTags(_attachmentMeta_.ogTags))
            .width(_attachmentMeta_.width)
            .height(_attachmentMeta_.height)
            .build()
    }

    fun convertOGTags(
        _ogTags_: _LinkOGTags_
    ): LinkOGTags {
        return LinkOGTags.Builder().url(_ogTags_.url)
            .title(_ogTags_.title)
            .image(_ogTags_.image)
            .description(_ogTags_.description)
            .build()
    }

    fun convertCommentsList(
        _comments_: List<_Comment_>?
    ): List<Comment>? {
        if (_comments_ == null) return null
        val comments = mutableListOf<Comment>()
        _comments_.forEach {
            comments.add(convertComment(it))
        }
        return comments
    }

    fun convertComment(
        _comment_: _Comment_
    ): Comment {
        return Comment.Builder()
            .id(_comment_.id)
            .isLiked(_comment_.isLiked)
            .userId(_comment_.userId)
            .text(_comment_.text)
            .level(_comment_.level)
            .likesCount(_comment_.likesCount)
            .commentsCount(_comment_.commentsCount)
            .createdAt(_comment_.createdAt)
            .updatedAt(_comment_.updatedAt)
            .menuItems(convertMenuItemsList(_comment_.menuItems))
            .parentId(_comment_.parentId)
            .build()
    }

    fun convertMenuItemsList(
        _menuItems_: List<_MenuItem_>
    ): List<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        _menuItems_.forEach {
            menuItems.add(convertMenuItem(it))
        }
        return menuItems
    }

    fun convertMenuItem(
        _menuItem_: _MenuItem_
    ): MenuItem {
        return MenuItem.Builder()
            .title(_menuItem_.title)
            .build()
    }

    fun createAttachmentsRequest(
        context: Context,
        attachments: MutableList<Attachment>?
    ): List<_Attachment_>? {
        if (attachments == null) return null
        val _attachments_ = mutableListOf<_Attachment_>()
        attachments.forEach { attachment ->
            val _attachment_ = _Attachment_.Builder()
                .attachmentType(attachment.attachmentType)
                .attachmentMeta(createAttachmentMetaRequest(context, attachment.attachmentMeta!!))
                .build()
            _attachments_.add(_attachment_)
        }
        return _attachments_
    }

    fun createAttachmentMetaRequest(
        context: Context,
        attachmentMeta: AttachmentMeta?
    ): _AttachmentMeta_? {
        if (attachmentMeta == null) return null
        val localFilePath = getRealPath(context, attachmentMeta.localFilePath!!.toUri())
        val name = getFileNameFromPath(localFilePath)
        val awsFolderPath = generateAWSFolderPathFromFilePath(name)
        return _AttachmentMeta_.Builder().name(name)
            .awsFolderPath(awsFolderPath)
            .url(generateUrlFromAWSFolderPath(awsFolderPath))
            .format(attachmentMeta.format)
            .size(attachmentMeta.size)
            .duration(attachmentMeta.duration)
            .pageCount(attachmentMeta.pageCount)
            .ogTags(createOGTags(attachmentMeta.ogTags))
            .awsFolderPath(awsFolderPath)
            .localFilePath(localFilePath)
            .width(attachmentMeta.width)
            .height(attachmentMeta.height)
            .build()
    }

    fun createOGTags(
        ogTags: LinkOGTags
    ): _LinkOGTags_ {
        return _LinkOGTags_.Builder().url(ogTags.url)
            .title(ogTags.title)
            .image(ogTags.image)
            .description(ogTags.description)
            .build()
    }
}