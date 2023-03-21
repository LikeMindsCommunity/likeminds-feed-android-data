package com.likeminds.likemindsfeed.initiateUser

import com.likeminds.internalsdk.TokenManager
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
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

    /**
     * Converts client request model to internal model and calls the api
     * @param initiateUserRequest - client request model to initiate user
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return InitiateUserResponse - InitiateUserResponse model for initiateUserRequest
     */
    suspend fun initiateUser(initiateUserRequest: InitiateUserRequest): LMResponse<InitiateUserResponse> {
        // validates the client request
        RequestUtils.validate()
        validateInitiateUserRequest(initiateUserRequest)

        // builds internal request model
        val request =
            _InitiateUserRequest_.Builder().userId(initiateUserRequest.userId)
                .apiKey(initiateUserRequest.apiKey)
                .userName(initiateUserRequest.userName)
                .isGuest(initiateUserRequest.isGuest)
                .build()
        val api = collabmatesSDK.getSDKApi()
        // calls api and processes the response accordingly
        return when (val response = api.initiateUser(request.apiKey!!, request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage,
                    InitiateUserResponse(
                        appAccess = false
                    )
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body

                val accessToken = body.data?.accessToken
                val refreshToken = body.data?.refreshToken
                val userId = body.data?.user?.id

                val tokenManager = TokenManager.getInstance()
                tokenManager.updateTokens(accessToken, refreshToken, userId)
                ModelConverter.convertInitiateUserResponse(body)
            }
        }
    }

    /**
     * Calls the MemberState api
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return MemberStateResponse - MemberStateResponse model for MemberState api call
     */
    suspend fun memberState(): LMResponse<MemberStateResponse> {
        // validates the client request
        RequestUtils.validate()

        val api = collabmatesSDK.getSDKApi()
        // calls api and processes the response accordingly
        return when (val response = api.memberState()) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertMemberStateResponse(response.body)
            }
        }
    }

    /**
     * validates initiateUserRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateInitiateUserRequest(initiateUserRequest: InitiateUserRequest) {
        if (initiateUserRequest.userId.isNullOrEmpty()) {
            RequestUtils.throwException("userId")
        }
        if (initiateUserRequest.isGuest == null) {
            RequestUtils.throwException("isGuest")
        }
        if (initiateUserRequest.apiKey.isEmpty()) {
            RequestUtils.throwException("apiKey")
        }
    }
}