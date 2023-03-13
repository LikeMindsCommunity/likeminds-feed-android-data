package com.likeminds.likemindsfeed.sdk

import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User

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
            convertCommunity(_community_)
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
}