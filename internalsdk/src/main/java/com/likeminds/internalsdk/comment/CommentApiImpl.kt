package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentApiImpl @Inject constructor(
    private val commentReceiver: CommentReceiver
) : CommentApi {

    override suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentReceiver.addComment(request)
    }

    override suspend fun addReplyOnComment(
        request: _AddReplyOnCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentReceiver.addReplyOnComment(request)
    }

    override suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_> {
        return commentReceiver.getComment(request)
    }

    override suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<_GetCommentLikesResponse_> {
        return commentReceiver.getCommentLikes(request)
    }

    override suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentReceiver.likeComment(request)
    }

    override suspend fun deleteComment(
        request: _DeleteCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentReceiver.deleteComment(request)
    }
}