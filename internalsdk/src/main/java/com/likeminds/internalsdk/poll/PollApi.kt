package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PollApi {

    //api to add option in a existing poll
    suspend fun addPollOption(
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>>

    // api to submit vote to a poll
    suspend fun submitVote(
        request: _SubmitVoteRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to get votes result for a poll
    suspend fun getPollVotes(
        request: _GetPollVotesRequest_
    ): NetworkResponse<APIResponse<_GetPollVotesResponse_>>
}