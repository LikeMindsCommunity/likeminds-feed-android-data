package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class FeedReceiver @Inject constructor(
    private val feedNetworkApi: FeedNetworkApi
) {

    companion object{
        private const val PAGE = "page"
        private const val PAGE_SIZE = "page_size"
    }

    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>> {
        val queries = HashMap<String, Any?>()
        queries[PAGE] = request.page
        queries[PAGE_SIZE] = request.pageSize

        if (!request.topicIds.isNullOrEmpty()) {
            queries["topic_ids"] = request.topicIds
        }

        return feedNetworkApi.getFeed(queries)
    }

    suspend fun getPersonalisedFeed(
        request: _GetPersonalisedFeedRequest_
    ): NetworkResponse<APIResponse<_GetPersonalisedFeedResponse_>> {
        val queries = HashMap<String, Any?>()
        queries[PAGE] = request.page
        queries[PAGE_SIZE] = request.pageSize

        if (request.shouldRecompute != null) {
            queries["should_recompute"] = request.shouldRecompute
        }

        if (request.shouldReorder != null) {
            queries["should_reorder"] = request.shouldReorder
        }

        return feedNetworkApi.getPersonalisedFeed(queries)
    }
}