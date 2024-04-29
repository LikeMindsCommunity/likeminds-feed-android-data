package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface PollNetworkApi {

    @PUT("poll/{poll_id}")
    suspend fun addPollOption(
        @Path("poll_id") pollId: String,
        @Body addPollOptionRequest_: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>>

    @PUT("poll/{poll_id}/vote")
    suspend fun submitVote(
        @Path("poll_id") pollId: String,
        @Body submitVoteRequest: _SubmitVoteRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    @GET("poll/{poll_id}/vote")
    suspend fun getPollVotes(
        @Path("poll_id") pollId: String,
        @QueryMap queries: HashMap<String, Any>
    ): NetworkResponse<APIResponse<_GetPollVotesResponse_>>
}