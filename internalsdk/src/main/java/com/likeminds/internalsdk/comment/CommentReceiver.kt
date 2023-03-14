package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentReceiver @Inject constructor(
    private val commentNetworkApi: CommentNetworkApi
) {

    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse> {
        val postId = request.postId ?: ""
        val newRequest = request.toBuilder().postId(null).build()
        return commentNetworkApi.addComment(postId, newRequest)
    }

    suspend fun addReplyOnComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse> {
        val postId = request.postId ?: ""
        val commentId = request.commentId ?: ""
        val newRequest = request.toBuilder()
            .postId(null)
            .commentId(null)
            .build()
        return commentNetworkApi.addReplyOnComment(
            postId,
            commentId,
            newRequest
        )
    }

    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_> {
        return commentNetworkApi.getComment(
            request.postId,
            request.commentId,
            request.page,
            request.pageSize
        )
    }

    suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<_GetCommentLikesResponse_> {
        return commentNetworkApi.getCommentLikes(
            request.postId,
            request.commentId,
            request.page,
            request.pageSize
        )
    }

    suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentNetworkApi.likeComment(
            request.postId,
            request.commentId
        )
    }

    suspend fun deleteComment(
        request: _DeleteCommentRequest_
    ): NetworkResponse<BaseResponse> {
        val postId = request.postId ?: ""
        val commentId = request.commentId!!
        val newRequest = request.toBuilder().postId(null).commentId(null).build()
        return commentNetworkApi.deleteComment(
            postId,
            commentId,
            newRequest
        )
    }
}