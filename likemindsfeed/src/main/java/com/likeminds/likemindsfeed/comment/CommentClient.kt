package com.likeminds.likemindsfeed.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
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
     * @return AddCommentResponse - client response model for addCommentRequest
     */
    suspend fun addComment(addCommentRequest: AddCommentRequest): AddCommentResponse {
        // builds internal request model
        val request = _AddCommentRequest_.Builder()
            .postId(addCommentRequest.postId)
            .text(addCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.addComment(request)) {
            is NetworkResponse.Error -> {
                AddCommentResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                AddCommentResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    // TODO: confirm
    /**
     * Converts client request model to internal model and calls the api
     * @param addCommentRequest - client request model to add comment on the post
     * @return AddCommentResponse - client response model for addCommentRequest
     */
    suspend fun addReplyOnComment(addCommentRequest: AddCommentRequest): AddCommentResponse {
        // builds internal request model
        val request = _AddCommentRequest_.Builder()
            .postId(addCommentRequest.postId)
            .commentId(addCommentRequest.commentId)
            .text(addCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.addReplyOnComment(request)) {
            is NetworkResponse.Error -> {
                AddCommentResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                AddCommentResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getCommentRequest - client request model to fetch comment and its paginated replies
     * @return GetCommentResponse - client response model for getCommentRequest
     */
    suspend fun getComment(getCommentRequest: GetCommentRequest): GetCommentResponse {
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
                GetCommentResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetCommentResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getCommentLikesRequest - client request model to fetch likes data on the comment
     * @return GetCommentLikesResponse - client response model for getCommentLikesRequest
     */
    suspend fun getCommentLikes(getCommentLikesRequest: GetCommentLikesRequest): GetCommentLikesResponse {
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
                GetCommentLikesResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetCommentLikesResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param likeCommentRequest - client request model to like the comment
     * @return LikeCommentResponse - client response model for likeCommentRequest
     */
    suspend fun likeComment(likeCommentRequest: LikeCommentRequest): LikeCommentResponse {
        // builds internal request model
        val request = _LikeCommentRequest_.Builder()
            .postId(likeCommentRequest.postId)
            .commentId(likeCommentRequest.commentId)
            .build()
        val api = collabmatesSDK.getCommentApi()
        // calls api and processes the response accordingly
        return when (val response = api.likeComment(request)) {
            is NetworkResponse.Error -> {
                LikeCommentResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LikeCommentResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param deleteCommentRequest - client request model to delete the comment
     * @return DeleteCommentResponse - client response model for deleteCommentRequest
     */
    suspend fun deleteComment(deleteCommentRequest: DeleteCommentRequest): DeleteCommentResponse {
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
                DeleteCommentResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                DeleteCommentResponse(
                    success = response.body.success,
                    errorMessage = null
                )
            }
        }
    }
}