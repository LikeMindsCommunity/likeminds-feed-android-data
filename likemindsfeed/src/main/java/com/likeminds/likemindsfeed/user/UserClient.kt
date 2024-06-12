package com.likeminds.likemindsfeed.user

import android.util.Log
import com.likeminds.internalsdk.FeedTokenManager
import com.likeminds.internalsdk.sdk.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.user.model.*
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class UserClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().initiateUserComponent()?.inject(this)
    }

    private val sdkApi by lazy {
        feedSDK.getSDKApi()
    }

    private val userDao by lazy {
        feedSDK.getUserWithRightsDao()
    }

    private val dbInstance by lazy {
        feedSDK.getDBInstance()
    }

    companion object {
        @JvmStatic
        private var userClient: UserClient? = null

        fun getInstance(): UserClient {
            if (userClient == null) {
                userClient = UserClient()
            }
            return userClient!!
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
            _InitiateUserRequest_.Builder().uuid(initiateUserRequest.uuid)
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
                    //update db
                    body.data?.user?.let { user ->
                        insertUser(user)
                    }

                    Log.d("PUI", "body: ${body.data}")
                    //return the exposed
                    ModelConverter.convertInitiateUserAPIResponse(body)
                }
            }
        }
    }

    /**
     * validates [initiateUserRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateInitiateUserRequest(initiateUserRequest: InitiateUserRequest) {
        if (initiateUserRequest.userName.isEmpty()) {
            RequestUtils.throwException("userName")
        }

        if (initiateUserRequest.deviceId.isEmpty()) {
            RequestUtils.throwException("deviceId")
        }

        if (initiateUserRequest.apiKey.isEmpty()) {
            RequestUtils.throwException("apiKey")
        }
    }

    //update DB for the user
    private suspend fun insertUser(_user_: _User_) {
        //get user entity
        val userEntity = ModelConverter.createUserEntity(_user_)

        //db query
        userDao.insertUser(userEntity)
    }

//    suspend fun validateUser():LMResponse<>

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
                .refreshToken(FeedTokenManager.getInstance().refreshToken ?: "")
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
                //clear tokens
                FeedTokenManager.getInstance().clear()

                //clear db
                clearDB()

                //return response
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
        if (logoutRequest.deviceId.isEmpty()) {
            RequestUtils.throwException("deviceId")
        }
    }

    //Clear all tables data
    private fun clearDB() {
        dbInstance.clearAllTables()
    }

    /**
     * Calls the MemberState api
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return MemberStateResponse - MemberStateResponse model for MemberState api call
     */
    suspend fun getMemberState(): LMResponse<GetMemberStateResponse> {
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
                val body = response.body
                body.data?.let { memberStateResponse ->
                    updateUserWithRightsInDb(memberStateResponse)
                }

                ModelConverter.convertMemberStateAPIResponse(body)
            }
        }
    }

    //update db for user with rights
    private suspend fun updateUserWithRightsInDb(memberStateResponse: _GetMemberStateResponse_) {
        //get response variables
        val uuid = memberStateResponse.member?.userUniqueId ?: return
        val state = memberStateResponse.state

        //get existing userEntity
        val userEntity = userDao.getUser(uuid)

        userEntity?.let { user ->
            //updated userEntity
            val updatedUser = user.toBuilder().state(state).build()

            val memberRightsEntity = ModelConverter.createMemberRightsEntity(
                uuid,
                memberStateResponse.memberRights
            )

            userDao.insertUserWithRights(updatedUser, memberRightsEntity)
        }
    }

    /**
     * Calls the db query to get the logged user details
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return GetLoggedInUserWithRightsResponse - GetLoggedInUserWithRightsResponse model
     */
    suspend fun getLoggedInUserWithRights(): LMResponse<GetLoggedInUserWithRightsResponse> {
        // validates the client request
        RequestUtils.validate()

        //query
        val userWithRights = userDao.getLoggedInUserWithRights()
        return if (userWithRights == null) {
            LMResponse(
                success = false,
                errorMessage = "Logged in user not found!"
            )
        } else {
            ModelConverter.convertGetLoggedInUserWithRightsResponse(userWithRights)
        }
    }

    suspend fun validateUser(validateUserRequest: ValidateUserRequest): LMResponse<ValidateUserResponse> {
        // validates the client request
        RequestUtils.validate()
        validateValidateUserRequest(validateUserRequest)

        val request = _ValidateUserRequest_.Builder()
            .accessToken(validateUserRequest.accessToken)
            .refreshToken(validateUserRequest.refreshToken)
            .build()

        return when (val response = sdkApi.validateUser(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body
                val accessToken = validateUserRequest.accessToken
                val refreshToken = validateUserRequest.refreshToken

                val feedTokenManager = FeedTokenManager.getInstance()
                feedTokenManager.updateTokens(accessToken, refreshToken)

                if (body.data?.appAccess == false) {
                    // logout the user if app access is false
                    val logoutRequest = LogoutRequest.Builder()
                        .deviceId(validateUserRequest.deviceId)
                        .build()

                    val logoutResponse = logout(logoutRequest)
                    LMResponse(
                        success = false,
                        body.errorMessage,
                        ValidateUserResponse(
                            appAccess = false,
                            logoutResponse = logoutResponse
                        )
                    )
                } else {
                    //update db
                    body.data?.user?.let { user ->
                        insertUser(user)
                    }

                    ModelConverter.convertValidateUserAPIResponse(body)
                }
            }
        }
    }

    private fun validateValidateUserRequest(validateUserRequest: ValidateUserRequest) {
        if (validateUserRequest.accessToken.isEmpty()) {
            RequestUtils.throwException("accessToken")
        }

        if (validateUserRequest.refreshToken.isEmpty()) {
            RequestUtils.throwException("refreshToken")
        }
    }
}