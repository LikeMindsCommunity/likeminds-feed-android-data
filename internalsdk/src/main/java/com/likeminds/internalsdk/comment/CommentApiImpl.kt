package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
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

    override suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_> {
        return commentReceiver.getComment(request)
    }
}