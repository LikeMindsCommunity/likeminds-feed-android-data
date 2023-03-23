package com.likeminds.likemindsfeed.initiateUser

import com.likeminds.internalsdk.FeedTokenManager
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.sdk.model._LogoutRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserResponse
import com.likeminds.likemindsfeed.initiateUser.model.LogoutRequest
import com.likeminds.likemindsfeed.initiateUser.model.MemberStateResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class InitiateUserClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().initiateUserComponent()?.inject(this)
    }

    private val sdkApi by lazy {
        collabmatesSDK.getSDKApi()
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

        // calls api and processes the response accordingly
        return when (val response = sdkApi.initiateUser(request.apiKey!!, request)) {
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
                val accessToken = body.data?.accessToken ?: ""
                val refreshToken = body.data?.refreshToken ?: ""

                val feedTokenManager = FeedTokenManager.getInstance()
                feedTokenManager.updateTokens(accessToken, refreshToken)

                if (body.data?.appAccess == false) {
                    // logout the user if app access is false
                    val logoutRequest = LogoutRequest.Builder()
                        .refreshToken(refreshToken)
                        .deviceId(initiateUserRequest.deviceId)
                        .build()

                    val logoutResponse = logout(logoutRequest)
                    LMResponse(
                        success = false,
                        body.errorMessage,
                        InitiateUserResponse(
                            appAccess = false,
                            logoutResponse = logoutResponse
                        )
                    )
                } else {
                    ModelConverter.convertInitiateUserResponse(body)
                }
            }
        }
    }

    /**
     * validates [initiateUserRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateInitiateUserRequest(initiateUserRequest: InitiateUserRequest) {
        if (initiateUserRequest.userName.isNullOrEmpty()) {
            RequestUtils.throwException("userName")
        }

        if (initiateUserRequest.deviceId.isEmpty()) {
            RequestUtils.throwException("deviceId")
        }

        if (initiateUserRequest.isGuest == null) {
            RequestUtils.throwException("isGuest")
        }

        if (initiateUserRequest.apiKey.isEmpty()) {
            RequestUtils.throwException("apiKey")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param logoutRequest - client request model to logout user
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun logout(logoutRequest: LogoutRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateLogoutResponse(logoutRequest)

        // builds internal request model
        val request =
            _LogoutRequest_.Builder()
                .refreshToken(logoutRequest.refreshToken)
                .deviceId(logoutRequest.deviceId)
                .build()

        return when (val response = sdkApi.logout(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [logoutRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateLogoutResponse(logoutRequest: LogoutRequest) {
        if (logoutRequest.refreshToken.isEmpty()) {
            RequestUtils.throwException("refreshToken")
        }
    }

    /**
     * Calls the MemberState api
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return MemberStateResponse - MemberStateResponse model for MemberState api call
     */
    suspend fun getMemberState(): LMResponse<MemberStateResponse> {
        // validates the client request
        RequestUtils.validate()

        // calls api and processes the response accordingly
        return when (val response = sdkApi.getMemberState()) {
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
}