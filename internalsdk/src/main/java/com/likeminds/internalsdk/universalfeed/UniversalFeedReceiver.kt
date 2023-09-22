package com.likeminds.internalsdk.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class UniversalFeedReceiver @Inject constructor(
    private val universalFeedNetworkApi: UniversalFeedNetworkApi
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

        return universalFeedNetworkApi.getFeed(
            queries
        )
    }
}