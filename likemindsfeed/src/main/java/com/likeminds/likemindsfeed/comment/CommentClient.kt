package com.likeminds.likemindsfeed.comment

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.comment.model.AddCommentRequest
import com.likeminds.likemindsfeed.comment.model.AddCommentResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class CommentClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().commentComponent()?.inject(this)
    }

    companion object {
        @JvmStatic
        private var commentClient: CommentClient? = null

        fun getInstance(): CommentClient {
            if (commentClient == null) {
                commentClient = CommentClient()
            }
            return commentClient!!
        }
    }

    suspend fun addComment(addCommentRequest: AddCommentRequest): AddCommentResponse {
        val request = _AddCommentRequest_.Builder()
            .text(addCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
        return when (val response = api.addComment(addCommentRequest.postId, request)) {
            is NetworkResponse.Error -> {
                AddCommentResponse(
                    success = false,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                AddCommentResponse(
                    success = true,
                    errorMessage = null
                )
            }
        }
    }
}