package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PollApiImpl @Inject constructor(
    private val pollReceiver: PollReceiver
) : PollApi {
    override suspend fun addPollOption(
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>> {
        return pollReceiver.addPollOption(request)
    }

    override suspend fun submitVote(request: _SubmitVoteRequest_): NetworkResponse<APIResponse<Nothing>> {
        return pollReceiver.submitVote(request)
    }

    override suspend fun getPollVotes(request: _GetPollVotesRequest_): NetworkResponse<APIResponse<_GetPollVotesResponse_>> {
        return pollReceiver.getPollVotes(request)
    }
}