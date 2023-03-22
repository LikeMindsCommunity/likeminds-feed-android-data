package com.likeminds.likemindsfeed.helper

import com.likeminds.internalsdk.helper.model._DecodeUrlRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.helper.model.DecodeUrlRequest
import com.likeminds.likemindsfeed.helper.model.DecodeUrlResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class HelperClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().helperComponent()?.inject(this)
    }

    companion object {
        @JvmStatic
        private var helperClient: HelperClient? = null

        fun getInstance(): HelperClient {
            if (helperClient == null) {
                helperClient = HelperClient()
            }
            return helperClient!!
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param decodeUrlRequest - client request model to add comment on the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun decodeUrl(decodeUrlRequest: DecodeUrlRequest): LMResponse<DecodeUrlResponse> {
        // validates the client request
        RequestUtils.validate()
        validateDecodeUrlRequest(decodeUrlRequest)

        // builds internal request model
        val request = _DecodeUrlRequest_.Builder()
            .url(decodeUrlRequest.url)
            .build()
        val api = collabmatesSDK.getHelperApi()
        // calls api and processes the response accordingly
        return when (val response = api.decodeUrl(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertDecodeUrlResponse(response.body)
            }
        }
    }

    /**
     * validates decodeUrlRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateDecodeUrlRequest(decodeUrlRequest: DecodeUrlRequest) {
        if (decodeUrlRequest.url.isEmpty()) {
            RequestUtils.throwException("url")
        }
    }
}