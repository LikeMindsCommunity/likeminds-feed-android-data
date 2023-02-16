package com.likeminds.likemindsfeed.initiateUser

import android.graphics.ColorSpace.Model
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUser
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
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
            //TODO: Confirm about the network and client models
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertInitiateUserResponse(body)
            }
        }
    }
}