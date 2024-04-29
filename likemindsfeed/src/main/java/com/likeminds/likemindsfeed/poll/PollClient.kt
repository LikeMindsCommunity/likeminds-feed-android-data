package com.likeminds.likemindsfeed.poll

import com.likeminds.internalsdk.poll.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.poll.model.*
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

    /**
     * Converts client request model to internal model and calls the api
     * @param addPollOptionRequest - client request model to add poll option
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or request is not valid
     * @return [AddPollOptionResponse] - AddPollOptionResponse model for addPollOption()
     */
    suspend fun addPollOption(addPollOptionRequest: AddPollOptionRequest): LMResponse<AddPollOptionResponse> {
        //validates the client request
        RequestUtils.validate()
        validateAddPollOptionRequest(addPollOptionRequest)

        //builds internal request model
        val request = _AddPollOptionRequest_.Builder()
            .pollId(addPollOptionRequest.pollId)
            .text(addPollOptionRequest.text)
            .build()


        //calls api and processes the response accordingly
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


    /**
     * validates [addPollOptionRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddPollOptionRequest(addPollOptionRequest: AddPollOptionRequest) {
        if (addPollOptionRequest.pollId.isEmpty()) {
            RequestUtils.throwException("poll id")
        }
        if (addPollOptionRequest.text.isEmpty()) {
            RequestUtils.throwException("poll option text")
        }
    }


    /**
     * Converts client request model to internal model and calls the api
     * @param submitVoteRequest - client request model to add poll option
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or request is not valid
     * @return [Nothing]
     */
    suspend fun submitVote(submitVoteRequest: SubmitVoteRequest): LMResponse<Nothing> {
        //validates the client request
        RequestUtils.validate()
        validateSubmitVoteRequest(submitVoteRequest)

        val request = _SubmitVoteRequest_.Builder()
            .pollId(submitVoteRequest.pollId)
            .votes(submitVoteRequest.votes)
            .build()

        return when (val response = pollApi.submitVote(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = true
                )
            }
        }
    }

    /**
     * validates [submitVoteRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateSubmitVoteRequest(submitVoteRequest: SubmitVoteRequest) {
        if (submitVoteRequest.pollId.isEmpty()) {
            RequestUtils.throwException("poll id")
        }

        if (submitVoteRequest.votes.isEmpty()) {
            RequestUtils.throwException("options ids")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPollVotesRequest - client request model to add poll option
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or request is not valid
     * @return [GetPollVotesResponse] - the response model for getPollVotes()
     */
    suspend fun getPollVotes(getPollVotesRequest: GetPollVotesRequest): LMResponse<GetPollVotesResponse> {
        //validates the client request
        RequestUtils.validate()
        validateGetPollVotesRequest(getPollVotesRequest)

        val request = _GetPollVotesRequest_.Builder()
            .pollId(getPollVotesRequest.pollId)
            .votes(getPollVotesRequest.votes)
            .build()

        return when (val response = pollApi.getPollVotes(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body
                ModelConverter.convertGetPollVotesAPIResponse(body)
            }
        }
    }

    /**
     * validates [getPollVotesRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateGetPollVotesRequest(getPollVotesRequest: GetPollVotesRequest) {
        if (getPollVotesRequest.pollId.isEmpty()) {
            RequestUtils.throwException("poll id")
        }
        if (getPollVotesRequest.votes.isEmpty()) {
            RequestUtils.throwException("options ids")
        }
    }
}