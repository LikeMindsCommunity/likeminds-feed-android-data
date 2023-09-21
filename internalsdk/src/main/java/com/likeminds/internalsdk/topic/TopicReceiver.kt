package com.likeminds.internalsdk.topic

import com.likeminds.internalsdk.topic.model._GetTopicsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class TopicReceiver @Inject constructor(
    private val topicNetworkApi: TopicNetworkApi
) {

    suspend fun getTopics(queries: HashMap<String, String>): NetworkResponse<APIResponse<_GetTopicsResponse_>> {
        return topicNetworkApi.getTopics(queries)
    }
}