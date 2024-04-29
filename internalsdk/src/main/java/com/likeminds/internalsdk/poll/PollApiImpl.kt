package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model._AddPollOptionRequest_
import com.likeminds.internalsdk.poll.model._AddPollOptionResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PollApiImpl @Inject constructor(
    private val pollReceiver: PollReceiver
) : PollApi {
    override suspend fun addPollOption(
        pollId: String,
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>> {
        return pollReceiver.addPollOption(pollId, request)
    }
}