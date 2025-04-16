package com.likeminds.likemindsfeed.feed

import com.likeminds.internalsdk.feed.model._GetFeedRequest_
import com.likeminds.internalsdk.feed.model._GetPersonalisedFeedRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.feed.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class FeedClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().universalFeedComponent()?.inject(this)
    }

    private val feedApi by lazy {
        feedSDK.feedApi()
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getFeedRequest - client request model to fetch feed
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return GetFeedResponse - GetFeedResponse model for getFeedRequest
     */
    suspend fun getFeed(getFeedRequest: GetFeedRequest): LMResponse<GetFeedResponse> {
        // validates the client request
        RequestUtils.validate()

        // builds internal request model
        val request = _GetFeedRequest_.Builder()
            .page(getFeedRequest.page)
            .pageSize(getFeedRequest.pageSize)
            .topicIds(getFeedRequest.topicIds)
            .startFeedWithPostIds(getFeedRequest.startFeedWithPostIds)
            .build()

        // calls api and processes the response accordingly
        return when (val response = feedApi.getFeed(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body
                ModelConverter.convertGetFeedAPIResponse(body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPersonalisedFeedRequest - client request model to fetch personalised feed
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return [GetPersonalisedFeedResponse] - GetPersonalisedFeedResponse model for getPersonalisedFeedRequest
     */
    suspend fun getPersonalisedFeed(getPersonalisedFeedRequest: GetPersonalisedFeedRequest): LMResponse<GetPersonalisedFeedResponse> {
        // validates the client request
        RequestUtils.validate()

        // builds internal request model
        val request = _GetPersonalisedFeedRequest_.Builder()
            .page(getPersonalisedFeedRequest.page)
            .pageSize(getPersonalisedFeedRequest.pageSize)
            .shouldReorder(getPersonalisedFeedRequest.shouldReorder)
            .shouldRecompute(getPersonalisedFeedRequest.shouldRecompute)
            .startFeedWithPostIds(getPersonalisedFeedRequest.startFeedWithPostIds)
            .build()

        // calls api and processes the response accordingly
        return when (val response = feedApi.getPersonalisedFeed(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body
                ModelConverter.convertPersonalisedFeedAPIResponse(body)
            }
        }
    }
}