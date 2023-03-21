package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentReceiver @Inject constructor(
    private val commentNetworkApi: CommentNetworkApi
) {

    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val postId = request.postId ?: ""
        val newRequest = request.toBuilder().postId(null).build()
        return commentNetworkApi.addComment(postId, newRequest)
    }

    suspend fun replyComment(
        request: _ReplyCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val postId = request.postId ?: ""
        val commentId = request.commentId ?: ""
        val newRequest = request.toBuilder()
            .postId(null)
            .commentId(null)
            .build()
        return commentNetworkApi.replyComment(
            postId,
            commentId,
            newRequest
        )
    }

    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<APIResponse<_GetCommentResponse_>> {
        return commentNetworkApi.getComment(
            request.postId,
            request.commentId,
            request.page,
            request.pageSize
        )
    }

    suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<APIResponse<_GetCommentLikesResponse_>> {
        return commentNetworkApi.getCommentLikes(
            request.postId,
            request.commentId,
            request.page,
            request.pageSize
        )
    }

    suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return commentNetworkApi.likeComment(
            request.postId,
            request.commentId
        )
    }

    suspend fun deleteComment(
        request: _DeleteCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
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