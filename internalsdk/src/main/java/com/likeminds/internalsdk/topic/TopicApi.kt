package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface TopicApi {

    // api to fetch all topics
    suspend fun getTopics(queries: HashMap<String, String>): NetworkResponse<APIResponse<_GetTopicsResponse_>>
}