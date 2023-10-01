package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsRequest_
import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface TopicApi {

    // api to fetch all topics
    suspend fun getTopics(request: _GetTopicsRequest_): NetworkResponse<APIResponse<_GetTopicsResponse_>>
}