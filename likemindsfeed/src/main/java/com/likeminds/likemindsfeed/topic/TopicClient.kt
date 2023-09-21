package com.likeminds.likemindsfeed.topic

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
        const val PAGE_QUERY = "page"
        const val PAGE_SIZE_QUERY = "page_size"
        const val IS_ENABLED_QUERY = "is_enabled"
        const val SEARCH_QUERY = "search"
        const val SEARCH_TYPE_QUERY = "search_type"
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

        //create queries map
        val queries = HashMap<String, String>()

        //add page and page size
        queries[PAGE_QUERY] = getTopicRequest.page.toString()
        queries[PAGE_SIZE_QUERY] = getTopicRequest.pageSize.toString()

        //add is enabled
        if (getTopicRequest.isEnabled != null) {
            queries[IS_ENABLED_QUERY] = getTopicRequest.isEnabled.toString()
        }

        //add search
        if (!getTopicRequest.search.isNullOrEmpty()) {
            queries[SEARCH_QUERY] = getTopicRequest.search
        }

        //add search type
        if (!getTopicRequest.searchType.isNullOrEmpty()) {
            queries[SEARCH_TYPE_QUERY] = getTopicRequest.searchType
        }

        //calls api and processes the response accordingly
        return when (val response = topicApi.getTopics(queries)) {
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