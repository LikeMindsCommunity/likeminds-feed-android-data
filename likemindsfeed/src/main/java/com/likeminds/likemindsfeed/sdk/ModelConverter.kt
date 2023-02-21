package com.likeminds.likemindsfeed.sdk

import android.util.Log
import com.likeminds.internalsdk.branding.model._BrandingAdvanced_
import com.likeminds.internalsdk.branding.model._BrandingBasic_
import com.likeminds.internalsdk.branding.model._BrandingResponse_
import com.likeminds.internalsdk.branding.model._Branding_
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._InitiateUserResponse_
import com.likeminds.internalsdk.sdk.model._SDKClientInfo_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.universalfeed.model._Posts_
import com.likeminds.likemindsfeed.branding.model.Branding
import com.likeminds.likemindsfeed.branding.model.BrandingAdvanced
import com.likeminds.likemindsfeed.branding.model.BrandingBasic
import com.likeminds.likemindsfeed.branding.model.BrandingResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import com.likeminds.likemindsfeed.universalfeed.model.Posts

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
            User(
                _user_.id,
                _user_.imageUrl,
                _user_.isGuest,
                _user_.name,
                _user_.organisationName,
                convertSDKClientInfo(_user_.sdkClientInfo),
                _user_.updatedAt,
                _user_.userUniqueId
            ),
            Community(
                _community_.id,
                _community_.name,
                _community_.imageUrl,
                _community_.membersCount,
                _community_.updatedAt,
            )
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
            convertPosts(_getFeedResponse_.data)
        )
    }

    fun convertPosts(
        _posts_: _Posts_?
    ): Posts {
        return Posts(
            _posts_?.posts
        )
    }
}