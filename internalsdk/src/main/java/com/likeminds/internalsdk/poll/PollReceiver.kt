package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model._AddPollOptionRequest_
import com.likeminds.internalsdk.poll.model._AddPollOptionResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PollReceiver @Inject constructor(
    private val pollNetworkApi: PollNetworkApi
) {
    suspend fun addPollOption(
        pollId: String,
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>> {
        return pollNetworkApi.addPollOption(pollId, request)
    }
}