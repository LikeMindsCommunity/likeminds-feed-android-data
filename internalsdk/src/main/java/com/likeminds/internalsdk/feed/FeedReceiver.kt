package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model._GetFeedRequest_
import com.likeminds.internalsdk.feed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class FeedReceiver @Inject constructor(
    private val feedNetworkApi: FeedNetworkApi
) {

    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>> {
        val queries = HashMap<String, Any?>()
        queries["page"] = request.page
        queries["page_size"] = request.pageSize

        if (!request.topicIds.isNullOrEmpty()) {
            queries["topic_ids"] = request.topicIds
        }

        return feedNetworkApi.getFeed(
            queries
        )
    }
}