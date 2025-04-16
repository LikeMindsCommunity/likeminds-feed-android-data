package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class FeedReceiver @Inject constructor(
    private val feedNetworkApi: FeedNetworkApi
) {

    companion object {
        private const val PAGE = "page"
        private const val PAGE_SIZE = "page_size"
        private const val TOPIC_IDS = "topic_ids"
        private const val SHOULD_RECOMPUTE = "should_recompute"
        private const val SHOULD_REORDER = "should_reorder"
        private const val POST_IDS = "post_ids"
    }

    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>> {
        val queries = HashMap<String, Any?>()
        queries[PAGE] = request.page
        queries[PAGE_SIZE] = request.pageSize

        if (!request.topicIds.isNullOrEmpty()) {
            queries[TOPIC_IDS] = request.topicIds
        }

        if (!request.startFeedWithPostIds.isNullOrEmpty()) {
            queries[POST_IDS] = request.startFeedWithPostIds
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
            queries[SHOULD_RECOMPUTE] = request.shouldRecompute
        }

        if (request.shouldReorder != null) {
            queries[SHOULD_REORDER] = request.shouldReorder
        }

        if (!request.startFeedWithPostIds.isNullOrEmpty()) {
            queries[POST_IDS] = request.startFeedWithPostIds
        }

        return feedNetworkApi.getPersonalisedFeed(queries)
    }
}