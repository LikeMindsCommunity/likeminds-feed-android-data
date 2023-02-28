package com.likeminds.likemindsfeed.comment

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentLikesRequest_
import com.likeminds.internalsdk.comment.model._GetCommentRequest_
import com.likeminds.internalsdk.comment.model._LikeCommentRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
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
            .postId(addCommentRequest.postId)
            .text(addCommentRequest.text)
            .build()
        val api = collabmatesSDK.getCommentApi()
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

    suspend fun getComment(getCommentRequest: GetCommentRequest): GetCommentResponse {
        val request = _GetCommentRequest_.Builder()
            .postId(getCommentRequest.postId)
            .commentId(getCommentRequest.commentId)
            .page(getCommentRequest.page)
            .pageSize(getCommentRequest.pageSize)
            .build()
        val api = collabmatesSDK.getCommentApi()
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

    suspend fun getCommentLikes(getCommentLikesRequest: GetCommentLikesRequest): GetCommentLikesResponse {
        val request = _GetCommentLikesRequest_.Builder()
            .postId(getCommentLikesRequest.postId)
            .commentId(getCommentLikesRequest.commentId)
            .page(getCommentLikesRequest.page)
            .pageSize(getCommentLikesRequest.pageSize)
            .build()
        val api = collabmatesSDK.getCommentApi()
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

    suspend fun likeComment(likeCommentRequest: LikeCommentRequest): LikeCommentResponse {
        val request = _LikeCommentRequest_.Builder()
            .postId(likeCommentRequest.postId)
            .commentId(likeCommentRequest.commentId)
            .build()
        val api = collabmatesSDK.getCommentApi()
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
}