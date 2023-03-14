package com.likeminds.likemindsfeed.sdk

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
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.ReportTag
import com.likeminds.likemindsfeed.post.model.GetPostLikesResponse
import com.likeminds.likemindsfeed.post.model.GetPostResponse
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.universalfeed.model.FeedData
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
            _getPostResponse_.post,
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
}