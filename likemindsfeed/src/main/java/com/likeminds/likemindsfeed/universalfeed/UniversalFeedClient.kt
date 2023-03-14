package com.likeminds.likemindsfeed.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject

class UniversalFeedClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().universalFeedComponent()?.inject(this)
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getFeedRequest - client request model to fetch feed
     * @return GetFeedResponse - client response model for getFeedRequest
     */
    suspend fun getFeed(getFeedRequest: GetFeedRequest): GetFeedResponse {
        // builds internal request model
        val request = _GetFeedRequest_.Builder().page(getFeedRequest.page)
            .pageSize(getFeedRequest.pageSize)
            .build()
        val api = collabmatesSDK.getUniversalFeedApi()
        // calls api and processes the response accordingly
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