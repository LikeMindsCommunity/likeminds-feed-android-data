package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommentApi {

    suspend fun addComment(
        postId: String,
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>
}