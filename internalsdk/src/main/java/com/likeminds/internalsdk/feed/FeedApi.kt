package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface FeedApi {

    // api to fetch paginated feed data
    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>>

    // api to fetch personalised feed data
    suspend fun getPersonalisedFeed(
        request: _GetPersonalisedFeedRequest_
    ): NetworkResponse<APIResponse<_GetPersonalisedFeedResponse_>>
}