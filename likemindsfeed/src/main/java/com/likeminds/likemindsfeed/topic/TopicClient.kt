package com.likeminds.likemindsfeed.topic

import com.likeminds.internalsdk.topic.model._GetTopicsRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.topic.model.GetTopicRequest
import com.likeminds.likemindsfeed.topic.model.GetTopicResponse
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class TopicClient @Inject constructor() : BaseClient() {

    companion object {

    }

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().topicComponent()?.inject(this)
    }

    private val topicApi by lazy {
        feedSDK.getTopicApi()
    }

    /**
     * Converts clients models to queries map and calls the api
     * @param getTopicRequest - client request model to fetch all topics
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return [GetTopicResponse] - GetTopicResponse model for getTopicRequest
     * */
    suspend fun getTopics(getTopicRequest: GetTopicRequest): LMResponse<GetTopicResponse> {
        // validates the client request
        RequestUtils.validate()

        val request = _GetTopicsRequest_.Builder()
            .page(getTopicRequest.page)
            .pageSize(getTopicRequest.pageSize)
            .search(getTopicRequest.search)
            .searchType(getTopicRequest.searchType)
            .isEnabled(getTopicRequest.isEnabled)
            .build()

        //calls api and processes the response accordingly
        return when (val response = topicApi.getTopics(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val data = response.body
                ModelConverter.convertGetTopicsAPIResponse(data)
            }
        }
    }
}