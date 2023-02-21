package com.likeminds.likemindsfeed.universalfeed

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.sdk.utils.SDKPreferences
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject

class UniversalFeedClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().universalFeedComponent()?.inject(this)
    }

    companion object {
        @JvmStatic
        private var universalFeedClient: UniversalFeedClient? = null

        fun getInstance(): UniversalFeedClient {
            if (universalFeedClient == null) {
                universalFeedClient = UniversalFeedClient()
            }
            return universalFeedClient!!
        }
    }

    suspend fun getFeed(request: _GetFeedRequest_): GetFeedResponse {
        val api = collabmatesSDK.getUniversalFeedApi()
        return when (val response = api.getFeed(request)) {
            is NetworkResponse.Error -> {
                GetFeedResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertGetFeedResponse(body)
            }
        }
    }
}