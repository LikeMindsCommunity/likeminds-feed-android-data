package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model._GetFeedRequest_
import com.likeminds.internalsdk.feed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface FeedApi {

    // api to fetch paginated feed data
    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>>
}