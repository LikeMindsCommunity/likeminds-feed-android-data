package com.likeminds.likemindsfeed.sdk

import com.likeminds.internalsdk.branding.model._BrandingAdvanced_
import com.likeminds.internalsdk.branding.model._BrandingBasic_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.branding.model._Branding_
import com.likeminds.internalsdk.comment.model._CommentData_
import com.likeminds.internalsdk.comment.model._CommentLikesData_
import com.likeminds.internalsdk.comment.model._GetCommentLikesResponse_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.post.model._GetPostLikesResponse_
import com.likeminds.internalsdk.post.model._GetPostResponse_
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponseData_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.branding.model.Branding
import com.likeminds.likemindsfeed.branding.model.BrandingAdvanced
import com.likeminds.likemindsfeed.branding.model.BrandingBasic
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.comment.model.CommentData
import com.likeminds.likemindsfeed.comment.model.CommentLikesData
import com.likeminds.likemindsfeed.comment.model.GetCommentLikesResponse
import com.likeminds.likemindsfeed.comment.model.GetCommentResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.post.model.GetPostLikesResponse
import com.likeminds.likemindsfeed.post.model.GetPostResponse
import com.likeminds.likemindsfeed.post.model.PostData
import com.likeminds.likemindsfeed.post.model.PostLikesData
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.universalfeed.model.FeedData
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse

object ModelConverter {

    /**--------------------------------
     * Internal Model -> Client Model
    --------------------------------*/

    // converts internal InitiateUserResponse model to client model
    fun convertInitiateUserResponse(
        _initiateUserResponse_: APIResponse<_InitiateUserResponseData_>
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

    // converts the internal User model hashmap to client model
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

    // converts internal BrandingResponse model to client model
    fun convertBrandingResponse(
        _brandingResponse_: _BrandingResponse_
    ): BrandingResponse {
        return BrandingResponse(
            _brandingResponse_.success,
            _brandingResponse_.errorMessage,
            convertBranding(_brandingResponse_.branding)
        )
    }

    // converts internal Branding model to client model
    fun convertBranding(
        _branding_: _Branding_?
    ): Branding {
        return Branding(
            convertBrandingBasic(_branding_?.basic),
            convertBrandingAdvanced(_branding_?.advanced)
        )
    }

    // converts internal BrandingBasic model to client model
    fun convertBrandingBasic(
        _brandingBasic_: _BrandingBasic_?
    ): BrandingBasic {
        return BrandingBasic(_brandingBasic_?.primaryColor)
    }

    // converts internal BrandingAdvanced model to client model
    fun convertBrandingAdvanced(
        _brandingAdvanced_: _BrandingAdvanced_?
    ): BrandingAdvanced {
        return BrandingAdvanced(
            _brandingAdvanced_?.headerColor,
            _brandingAdvanced_?.buttonsIconsColor,
            _brandingAdvanced_?.textLinksColor,
        )
    }

    // converts internal GetFeedResponse model to client model
    fun convertGetFeedResponse(
        _getFeedResponse_: _GetFeedResponse_
    ): GetFeedResponse {
        return GetFeedResponse(
            _getFeedResponse_.success,
            _getFeedResponse_.errorMessage,
            FeedData(
                _getFeedResponse_.data.posts,
                convertUsersMap(_getFeedResponse_.data.users)
            )
        )
    }

    // converts internal GetPostResponse model to client model
    fun convertGetPostResponse(
        _getPostResponse_: _GetPostResponse_
    ): GetPostResponse {
        return GetPostResponse(
            _getPostResponse_.success,
            _getPostResponse_.errorMessage,
            PostData(
                _getPostResponse_.data.post,
                convertUsersMap(_getPostResponse_.data.users)
            )
        )
    }

    // converts internal GetPostLikesResponse model to client model
    fun convertGetPostLikesResponse(
        _getPostLikesResponse_: _GetPostLikesResponse_
    ): GetPostLikesResponse {
        return GetPostLikesResponse(
            _getPostLikesResponse_.success,
            _getPostLikesResponse_.errorMessage,
            PostLikesData(
                _getPostLikesResponse_.data.likes,
                _getPostLikesResponse_.data.totalCount,
                convertUsersMap(_getPostLikesResponse_.data.users)
            )
        )
    }

    // converts internal GetCommentResponse model to client model
    fun convertGetCommentResponse(
        _getCommentResponse_: _GetCommentResponse_
    ): GetCommentResponse {
        return GetCommentResponse(
            _getCommentResponse_.success,
            _getCommentResponse_.errorMessage,
            convertCommentData(_getCommentResponse_.data)
        )
    }

    // converts internal CommentData model to client model
    fun convertCommentData(
        _commentData_: _CommentData_?
    ): CommentData? {
        if (_commentData_ == null) return null
        return CommentData(
            _commentData_.comment,
            convertUsersMap(_commentData_.users)
        )
    }

    // converts internal GetCommentLikesResponse model to client model
    fun convertGetCommentLikesResponse(
        _getCommentLikesResponse_: _GetCommentLikesResponse_
    ): GetCommentLikesResponse {
        return GetCommentLikesResponse(
            _getCommentLikesResponse_.success,
            _getCommentLikesResponse_.errorMessage,
            convertCommentLikesData(_getCommentLikesResponse_.data)
        )
    }

    // converts internal CommentLikesData model to client model
    fun convertCommentLikesData(
        _commentLikesData_: _CommentLikesData_?
    ): CommentLikesData? {
        if (_commentLikesData_ == null) return null
        return CommentLikesData(
            _commentLikesData_.likes,
            _commentLikesData_.totalCount,
            convertUsersMap(_commentLikesData_.users)
        )
    }
}