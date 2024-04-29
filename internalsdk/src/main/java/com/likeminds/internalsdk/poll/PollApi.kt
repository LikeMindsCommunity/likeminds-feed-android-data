package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PollApi {

    suspend fun addPollOption(
        request: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>>

    suspend fun submitVote(
        request: _SubmitVoteRequest_
    ): NetworkResponse<APIResponse<Nothing>>
}