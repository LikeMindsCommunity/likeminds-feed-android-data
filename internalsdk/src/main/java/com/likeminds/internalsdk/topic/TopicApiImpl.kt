package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsRequest_
import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class TopicApiImpl @Inject constructor(
    private val topicReceiver: TopicReceiver
) : TopicApi {
    override suspend fun getTopics(request: _GetTopicsRequest_): NetworkResponse<APIResponse<_GetTopicsResponse_>> {
        return topicReceiver.getTopics(request)
    }
}