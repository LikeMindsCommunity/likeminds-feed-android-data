package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentApiImpl @Inject constructor(
    private val commentReceiver: CommentReceiver
) : CommentApi {

    override suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<APIResponse<_AddCommentResponse_>> {
        return commentReceiver.addComment(request)
    }

    override suspend fun replyComment(
        request: _ReplyCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return commentReceiver.replyComment(request)
    }

    override suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<APIResponse<_GetCommentResponse_>> {
        return commentReceiver.getComment(request)
    }

    override suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<APIResponse<_GetCommentLikesResponse_>> {
        return commentReceiver.getCommentLikes(request)
    }

    override suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return commentReceiver.likeComment(request)
    }

    override suspend fun deleteComment(
        request: _DeleteCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return commentReceiver.deleteComment(request)
    }
}