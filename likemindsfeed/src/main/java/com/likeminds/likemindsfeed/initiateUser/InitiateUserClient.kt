package com.likeminds.likemindsfeed.initiateUser

import android.util.Log
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.TokenManager
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
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

    suspend fun initiateUser(request: _InitiateUserRequest_): InitiateUserResponse? {
        val api = collabmatesSDK.getSDKApi()
        return when (val response = api.initiate(sdkPreferences.getAPIKey(), request)) {
            is NetworkResponse.Error -> {
                Log.d("TAG", "initiateUser: failed")
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
                Log.d(
                    "TAG",
                    "initiateUser: " + tokenManager + " " + tokenManager.accessToken + tokenManager.memberId
                )
                return ModelConverter.convertInitiateUserResponse(body)
            }
        }
    }
}