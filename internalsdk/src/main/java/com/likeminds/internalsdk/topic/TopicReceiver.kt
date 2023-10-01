package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsRequest_
import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class TopicReceiver @Inject constructor(
    private val topicNetworkApi: TopicNetworkApi
) {

    companion object {
        const val PAGE_QUERY = "page"
        const val PAGE_SIZE_QUERY = "page_size"
        const val IS_ENABLED_QUERY = "is_enabled"
        const val SEARCH_QUERY = "search"
        const val SEARCH_TYPE_QUERY = "search_type"
    }

    suspend fun getTopics(request: _GetTopicsRequest_): NetworkResponse<APIResponse<_GetTopicsResponse_>> {
        //create queries map
        val queries = HashMap<String, String>()

        //add page and page size
        queries[PAGE_QUERY] = request.page.toString()
        queries[PAGE_SIZE_QUERY] = request.pageSize.toString()

        //add is enabled
        if (request.isEnabled != null) {
            queries[IS_ENABLED_QUERY] = request.isEnabled.toString()
        }

        //add search
        if (!request.search.isNullOrEmpty()) {
            queries[SEARCH_QUERY] = request.search
        }

        //add search type
        if (!request.searchType.isNullOrEmpty()) {
            queries[SEARCH_TYPE_QUERY] = request.searchType
        }

        return topicNetworkApi.getTopics(queries)
    }
}