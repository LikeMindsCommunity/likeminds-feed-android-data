package com.likeminds.likemindsfeed.initiateUser

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.sdk.model._InitiateUserRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
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

    suspend fun initiateUser(request_: _InitiateUserRequest_): Boolean {
        val api = collabmatesSDK.getSDKApi()
        return when (api.initiate(sdkPreferences.getAPIKey(), request_)) {
            is NetworkResponse.Error -> {
                false
            }
            is NetworkResponse.Success -> {
                true
            }
        }
    }
}