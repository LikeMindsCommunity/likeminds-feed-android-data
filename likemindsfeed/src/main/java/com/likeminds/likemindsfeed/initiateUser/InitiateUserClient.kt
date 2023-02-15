package com.likeminds.likemindsfeed.initiateUser

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.SDKClientInfo
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.sdk.utils.SDKPreferences
import javax.inject.Inject

class InitiateUserClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().initiateUserComponent()?.inject(this)
    }

    companion object {
        @JvmStatic
        private var initiateUserClient: InitiateUserClient? = null

        fun getInstance(): InitiateUserClient {
            if (initiateUserClient == null) {
                initiateUserClient = InitiateUserClient()
            }
            return initiateUserClient!!
        }
    }

    suspend fun initiateUser(request_: _InitiateUserRequest_): InitiateUserResponse? {
        val api = collabmatesSDK.getSDKApi()
        return when (val response = api.initiate(sdkPreferences.getAPIKey(), request_)) {
            is NetworkResponse.Error -> {
                null
            }
            is NetworkResponse.Success -> {
                val body = response.body
                val user = body.data?.user!!
                val community = body.data?.community!!
                val sdkClientInfo = user.sdkClientInfo?.let {
                    SDKClientInfo(
                        it.community,
                        it.user,
                        it.userUniqueId
                    )
                }
                val initiateUser = InitiateUser(
                    User(
                        user.id,
                        user.imageUrl,
                        user.isGuest,
                        user.name,
                        user.organisationName,
                        sdkClientInfo,
                        user.updatedAt,
                        user.userUniqueId
                    ),
                    Community(
                        community.id,
                        community.name
                    )
                )
                return InitiateUserResponse(
                    body.success,
                    body.errorMessage,
                    body.data?.appAccess,
                    initiateUser,
                )
            }
        }
    }
}