package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model._GetFeedResponse_
import com.likeminds.internalsdk.feed.model._GetPersonalisedFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FeedNetworkApi {

    @GET("feed/universal")
    suspend fun getFeed(
        @QueryMap queries: HashMap<String, Any?>
    ): NetworkResponse<APIResponse<_GetFeedResponse_>>

    @GET("feed/personalised")
    suspend fun getPersonalisedFeed(
        @QueryMap queries: HashMap<String, Any?>
    ): NetworkResponse<APIResponse<_GetPersonalisedFeedResponse_>>
}