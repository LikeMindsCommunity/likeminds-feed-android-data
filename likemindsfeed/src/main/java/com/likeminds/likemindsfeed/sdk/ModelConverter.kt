package com.likeminds.likemindsfeed.sdk

import com.likeminds.internalsdk.comment.model._Comment_
import com.likeminds.internalsdk.comment.model._GetCommentLikesResponse_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.moderation.model._ReportTag_
import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.sdk.model.*
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.comment.model.Comment
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.ReportTag
import com.likeminds.likemindsfeed.post.model.*
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
    fun convertInitiateUserResponse(
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
            _user_.isDeleted,
            _user_.customTitle,
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
    fun convertMemberStateResponse(
        _memberStateResponse_: _MemberStateResponse_?
    ): MemberStateResponse? {
        if (_memberStateResponse_ == null) return null
        return MemberStateResponse(
            _memberStateResponse_.state
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
            convertLikesList(_getPostLikesResponse_.likes),
            _getPostLikesResponse_.totalCount,
            convertUsersMap(_getPostLikesResponse_.users)
        )
    }

    // converts internal Like model list to client model list
    fun convertLikesList(
        _likes_: List<_Like_>
    ): List<Like> {
        val likes = mutableListOf<Like>()
        _likes_.forEach {
            likes.add(convertLike(it))
        }
        return likes
    }

    // converts internal Like model to client model
    fun convertLike(
        _like_: _Like_
    ): Like {
        return Like(
            _like_.id,
            _like_.createdAt,
            _like_.updatedAt,
            _like_.userId,
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
    fun convertGetCommentLikesResponse(
        _getCommentLikesResponse_: _GetCommentLikesResponse_?
    ): GetCommentLikesResponse? {
        if (_getCommentLikesResponse_ == null) return null
        return GetCommentLikesResponse(
            convertLikesList(_getCommentLikesResponse_.likes),
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

    // converts internal Post model list to client model list
    fun convertPostsList(
        _posts_: List<_Post_>
    ): List<Post> {
        val posts = mutableListOf<Post>()
        _posts_.forEach {
            posts.add(convertPost(it))
        }
        return posts
    }

    // converts internal Post model to client model
    fun convertPost(
        _post_: _Post_
    ): Post {
        return Post(
            _post_.id,
            _post_.text,
            convertAttachmentsList(_post_.attachments),
            _post_.communityId,
            _post_.isLiked,
            _post_.isPinned,
            _post_.userId,
            _post_.likesCount,
            _post_.commentsCount,
            _post_.isSaved,
            convertMenuItemsList(_post_.menuItems),
            convertCommentsList(_post_.replies),
            _post_.createdAt,
            _post_.updatedAt
        )
    }

    // converts internal Attachment model list to client model list
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

    // converts internal Attachment model to client model
    fun convertAttachment(
        _attachment_: _Attachment_
    ): Attachment {
        return Attachment.Builder()
            .attachmentType(_attachment_.attachmentType)
            .attachmentMeta(convertAttachmentMeta(_attachment_.attachmentMeta))
            .build()
    }

    // converts internal AttachmentMeta model to client model
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

    // converts internal LinkOGTags model to client model
    fun convertOGTags(
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

    // converts internal Comment model to client model
    fun convertComment(
        _comment_: _Comment_
    ): Comment {
        return Comment(
            _comment_.id,
            _comment_.isLiked,
            _comment_.userId,
            _comment_.text,
            _comment_.level,
            _comment_.likesCount,
            _comment_.commentsCount,
            _comment_.createdAt,
            _comment_.updatedAt,
            convertCommentsList(_comment_.replies),
            convertMenuItemsList(_comment_.menuItems),
            _comment_.parentId,
        )
    }

    // converts internal MenuItem model list to client model list
    fun convertMenuItemsList(
        _menuItems_: List<_MenuItem_>
    ): List<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        _menuItems_.forEach {
            menuItems.add(convertMenuItem(it))
        }
        return menuItems
    }

    // converts internal MenuItem model to client model
    fun convertMenuItem(
        _menuItem_: _MenuItem_
    ): MenuItem {
        return MenuItem(_menuItem_.title)
    }

    /**--------------------------------
     * Client Model -> Internal Model
    --------------------------------*/

    // create a list of internal attachments from the client list
    fun createAttachments(
//        context: Context,
        attachments: List<Attachment>?
    ): List<_Attachment_>? {
        if (attachments == null) return null
        val _attachments_ = mutableListOf<_Attachment_>()
        attachments.forEach { attachment ->
            val _attachment_ = _Attachment_.Builder()
                .attachmentType(attachment.attachmentType)
                .attachmentMeta(createAttachmentMeta(attachment.attachmentMeta!!))
                .build()
            _attachments_.add(_attachment_)
        }
        return _attachments_
    }

    // create a internal attachment meta from the meta provided by client
    fun createAttachmentMeta(
//        context: Context,
        attachmentMeta: AttachmentMeta?
    ): _AttachmentMeta_? {
        if (attachmentMeta == null) return null
//        // generates localFilePath from the ContentUri provided by client
//        val localFilePath = getRealPath(context, attachmentMeta.localFilePath!!.toUri())
//        // generates filename from localFilePath
//        val name = getFileNameFromPath(localFilePath)
//        Log.d("PUI", "createAttachmentMeta: $name")
//        // generates awsFolderPath to upload the file
//        val awsFolderPath = generateAWSFolderPathFromFileName(name)
//        Log.d("PUI", "createAttachmentMeta: awsfolder: $awsFolderPath")
//        return _AttachmentMeta_.Builder()
//            .name(name)
//            .url(generateUrlFromAWSFolderPath(awsFolderPath))
//            .format(attachmentMeta.format)
//            .size(attachmentMeta.size)
//            .duration(attachmentMeta.duration)
//            .pageCount(attachmentMeta.pageCount)
//            .ogTags(createOGTags(attachmentMeta.ogTags))
//            .awsFolderPath(awsFolderPath)
//            .localFilePath(localFilePath)
//            .width(attachmentMeta.width)
//            .height(attachmentMeta.height)
//            .build()
        return _AttachmentMeta_.Builder()
            .name(attachmentMeta.name)
            .url(attachmentMeta.url)
            .format(attachmentMeta.format)
            .size(attachmentMeta.size)
            .duration(attachmentMeta.duration)
            .pageCount(attachmentMeta.pageCount)
            .ogTags(createOGTags(attachmentMeta.ogTags))
            .width(attachmentMeta.width)
            .height(attachmentMeta.height)
            .build()
    }

    // converts client LinkOGTags model to internal model
    fun createOGTags(
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