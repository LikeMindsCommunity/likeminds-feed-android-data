package com.likeminds.likemindsfeed.poll

import com.likeminds.internalsdk.poll.model._AddPollOptionRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.poll.model.AddPollOptionRequest
import com.likeminds.likemindsfeed.poll.model.AddPollOptionResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class PollClient @Inject constructor() : BaseClient() {
    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().pollComponent()?.inject(this)
    }

    private val pollApi by lazy {
        feedSDK.getPollApi()
    }

    suspend fun addPollOption(addPollOptionRequest: AddPollOptionRequest): LMResponse<AddPollOptionResponse> {
        //validates the client request
        RequestUtils.validate()
        validateAddPollOptionRequest(addPollOptionRequest)

        val request = _AddPollOptionRequest_.Builder()
            .pollId(addPollOptionRequest.pollId)
            .text(addPollOptionRequest.text)
            .build()

        return when (val response = pollApi.addPollOption(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body

                ModelConverter.convertAddPollOptionAPIResponse(body)
            }
        }
    }


    //validates the add poll option request
    private fun validateAddPollOptionRequest(request: AddPollOptionRequest) {
        if (request.pollId.isEmpty()) {
            RequestUtils.throwException("poll id")
        }
        if (request.text.isEmpty()) {
            RequestUtils.throwException("poll option text")
        }
    }
}