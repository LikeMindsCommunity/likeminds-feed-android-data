package com.likeminds.likemindsfeed.initiateUser

import android.util.Log
import com.likeminds.internalsdk.TokenManager
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class InitiateUserClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
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

    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): InitiateUserResponse? {
        val request =
            _InitiateUserRequest_.Builder().userId(initiateUserRequest.userId)
                .userName(initiateUserRequest.userName)
                .isGuest(initiateUserRequest.isGuest)
                .build()
        val api = collabmatesSDK.getSDKApi()
        return when (val response = api.initiate(sdkPreferences.getAPIKey(), request)) {
            is NetworkResponse.Error -> {
                null
            }
            //TODO: Confirm about the network and client models
            is NetworkResponse.Success -> {
                val body = response.body

                val accessToken = response.body.data?.accessToken
                val refreshToken = response.body.data?.refreshToken
                val userId = response.body.data?.user?.id

                val tokenManager = TokenManager.getInstance()
                tokenManager.updateTokens(accessToken, refreshToken, userId)
                return ModelConverter.convertInitiateUserResponse(body)
            }
        }
    }
}