package com.likeminds.internalsdk.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversalFeedNetworkApi {

    @GET("feed/universal")
    suspend fun getFeed(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): NetworkResponse<APIResponse<_GetFeedResponse_>>
}