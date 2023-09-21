package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TopicNetworkApi {

    @GET("feed/topic")
    suspend fun getTopics(@QueryMap queries: HashMap<String, String>): NetworkResponse<APIResponse<_GetTopicsResponse_>>
}