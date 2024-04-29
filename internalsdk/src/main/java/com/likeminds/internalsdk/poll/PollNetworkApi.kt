package com.likeminds.internalsdk.poll

import com.likeminds.internalsdk.poll.model._AddPollOptionRequest_
import com.likeminds.internalsdk.poll.model._AddPollOptionResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface PollNetworkApi {

    @PUT("poll/{poll_id}")
    suspend fun addPollOption(
        @Path("poll_id") pollId: String,
        @Body addPollOptionRequest_: _AddPollOptionRequest_
    ): NetworkResponse<APIResponse<_AddPollOptionResponse_>>
}