package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommentApi {

    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_>
}