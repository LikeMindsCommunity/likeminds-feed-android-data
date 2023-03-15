package com.likeminds.likemindsfeed.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class CommentClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
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

    /**
     * Converts client request model to internal model and calls the api
     * @param addCommentRequest - client request model to add comment on the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun addComment(addCommentRequest: AddCommentRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateAddCommentRequest(addCommentRequest)

        // builds internal request model
        val request = _AddCommentRequest_.Builder()
            .postId(addCommentRequest.postId)
            .text(addCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.addComment(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * validates addCommentRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddCommentRequest(addCommentRequest: AddCommentRequest) {
        if (addCommentRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (addCommentRequest.text.isEmpty()) {
            RequestUtils.throwException("text")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param addReplyOnCommentRequest - client request model to add comment on the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun addReplyOnComment(addReplyOnCommentRequest: AddReplyOnCommentRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateAddReplyOnCommentRequest(addReplyOnCommentRequest)

        // builds internal request model
        val request = _AddReplyOnCommentRequest_.Builder()
            .postId(addReplyOnCommentRequest.postId)
            .commentId(addReplyOnCommentRequest.commentId)
            .text(addReplyOnCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.addReplyOnComment(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * validates addReplyOnCommentRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddReplyOnCommentRequest(addReplyOnCommentRequest: AddReplyOnCommentRequest) {
        if (addReplyOnCommentRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (addReplyOnCommentRequest.commentId.isEmpty()) {
            RequestUtils.throwException("commentId")
        }
        if (addReplyOnCommentRequest.text.isEmpty()) {
            RequestUtils.throwException("text")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getCommentRequest - client request model to fetch comment and its paginated replies
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return GetCommentResponse - GetCommentResponse model for getCommentRequest
     */
    suspend fun getComment(getCommentRequest: GetCommentRequest): LMResponse<GetCommentResponse> {
        // validates the client request
        RequestUtils.validate()
        validateGetCommentRequest(getCommentRequest)

        // builds internal request model
        val request = _GetCommentRequest_.Builder()
            .postId(getCommentRequest.postId)
            .commentId(getCommentRequest.commentId)
            .page(getCommentRequest.page)
            .pageSize(getCommentRequest.pageSize)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.getComment(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetCommentAPIResponse(response.body)
            }
        }
    }

    /**
     * validates getCommentRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateGetCommentRequest(getCommentRequest: GetCommentRequest) {
        if (getCommentRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (getCommentRequest.commentId.isEmpty()) {
            RequestUtils.throwException("commentId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getCommentLikesRequest - client request model to fetch likes data on the comment
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return GetCommentLikesResponse - GetCommentLikesResponse model for getCommentLikesRequest
     */
    suspend fun getCommentLikes(getCommentLikesRequest: GetCommentLikesRequest): LMResponse<GetCommentLikesResponse> {
        // validates the client request
        RequestUtils.validate()
        validateGetCommentLikesRequest(getCommentLikesRequest)

        // builds internal request model
        val request = _GetCommentLikesRequest_.Builder()
            .postId(getCommentLikesRequest.postId)
            .commentId(getCommentLikesRequest.commentId)
            .page(getCommentLikesRequest.page)
            .pageSize(getCommentLikesRequest.pageSize)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.getCommentLikes(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetCommentLikesAPIResponse(response.body)
            }
        }
    }

    /**
     * validates getCommentLikesRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateGetCommentLikesRequest(getCommentLikesRequest: GetCommentLikesRequest) {
        if (getCommentLikesRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (getCommentLikesRequest.commentId.isEmpty()) {
            RequestUtils.throwException("commentId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param likeCommentRequest - client request model to like the comment
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun likeComment(likeCommentRequest: LikeCommentRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateLikeCommentRequest(likeCommentRequest)

        // builds internal request model
        val request = _LikeCommentRequest_.Builder()
            .postId(likeCommentRequest.postId)
            .commentId(likeCommentRequest.commentId)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.likeComment(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * validates likeCommentRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateLikeCommentRequest(likeCommentRequest: LikeCommentRequest) {
        if (likeCommentRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (likeCommentRequest.commentId.isEmpty()) {
            RequestUtils.throwException("commentId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param deleteCommentRequest - client request model to delete the comment
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun deleteComment(deleteCommentRequest: DeleteCommentRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateDeleteCommentRequest(deleteCommentRequest)

        // builds internal request model
        val request = _DeleteCommentRequest_.Builder()
            .postId(deleteCommentRequest.postId)
            .commentId(deleteCommentRequest.commentId)
            .reason(deleteCommentRequest.reason)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.deleteComment(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * validates deleteCommentRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateDeleteCommentRequest(deleteCommentRequest: DeleteCommentRequest) {
        if (deleteCommentRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
        if (deleteCommentRequest.commentId.isEmpty()) {
            RequestUtils.throwException("commentId")
        }
    }
}