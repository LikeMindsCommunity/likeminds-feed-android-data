package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PollReceiver @Inject constructor(
    private val pollNetworkApi: PollNetworkApi
) {
    suspend fun addPollOption(
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>> {
        val pollId = request.pollId ?: ""
        val newRequest = request.toBuilder().pollId(null).build()

        return pollNetworkApi.addPollOption(pollId, newRequest)
    }

    suspend fun submitVote(
        request: _SubmitVoteRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val pollId = request.pollId ?: ""
        val newRequest = request.toBuilder().pollId(null).build()

        return pollNetworkApi.submitVote(pollId, newRequest)
    }
}