package com.likeminds.likemindsfeed.sdk

import android.content.Context
import androidx.core.net.toUri
import com.likeminds.internalsdk.branding.model._BrandingAdvanced_
import com.likeminds.internalsdk.branding.model._BrandingBasic_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.branding.model._Branding_
import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.likemindsfeed.branding.model.Branding
import com.likeminds.likemindsfeed.branding.model.BrandingAdvanced
import com.likeminds.likemindsfeed.branding.model.BrandingBasic
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
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
import com.likeminds.likemindsfeed.universalfeed.model.FeedData
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse

object ModelConverter {

    fun convertInitiateUserResponse(
        _initiateUserResponse_: _InitiateUserResponse_
    ): InitiateUserResponse {
        return InitiateUserResponse(
            _initiateUserResponse_.success,
            _initiateUserResponse_.errorMessage,
            _initiateUserResponse_.data?.appAccess,
            convertInitiateUser(
                _initiateUserResponse_.data?.user!!,
                _initiateUserResponse_.data?.community!!
            )
        )
    }

    fun convertInitiateUser(
        _user_: _User_,
        _community_: _Community_
    ): InitiateUser {
        return InitiateUser(
            convertUser(_user_),
            Community(
                _community_.id,
                _community_.name,
                _community_.imageUrl,
                _community_.membersCount,
                _community_.updatedAt,
            )
        )
    }

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

    fun convertUsersMap(
        _usersMap_: Map<String, _User_>?
    ): Map<String, User>? {
        val usersMap = _usersMap_?.mapValues {
            convertUser(it.value)
        }
        return usersMap
    }

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

    fun convertBrandingResponse(
        _brandingResponse_: _BrandingResponse_
    ): BrandingResponse {
        return BrandingResponse(
            _brandingResponse_.success,
            _brandingResponse_.errorMessage,
            convertBranding(_brandingResponse_.branding)
        )
    }

    fun convertBranding(
        _branding_: _Branding_?
    ): Branding {
        return Branding(
            convertBrandingBasic(_branding_?.basic),
            convertBrandingAdvanced(_branding_?.advanced)
        )
    }

    fun convertBrandingBasic(
        _brandingBasic_: _BrandingBasic_?
    ): BrandingBasic {
        return BrandingBasic(_brandingBasic_?.primaryColor)
    }

    fun convertBrandingAdvanced(
        _brandingAdvanced_: _BrandingAdvanced_?
    ): BrandingAdvanced {
        return BrandingAdvanced(
            _brandingAdvanced_?.headerColor,
            _brandingAdvanced_?.buttonsIconsColor,
            _brandingAdvanced_?.textLinksColor,
        )
    }

    fun convertGetFeedResponse(
        _getFeedResponse_: _GetFeedResponse_
    ): GetFeedResponse {
        return GetFeedResponse(
            _getFeedResponse_.success,
            _getFeedResponse_.errorMessage,
            FeedData(
                convertPostsList(_getFeedResponse_.data?.posts!!),
                convertUsersMap(_getFeedResponse_.data?.users)
            )
        )
    }

    fun convertGetPostResponse(
        _getPostResponse_: _GetPostResponse_
    ): GetPostResponse {
        return GetPostResponse(
            _getPostResponse_.success,
            _getPostResponse_.errorMessage,
            PostData(
                convertPost(_getPostResponse_.data?.post!!),
                convertUsersMap(_getPostResponse_.data?.users)
            )
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