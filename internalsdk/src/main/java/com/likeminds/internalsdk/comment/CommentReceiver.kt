package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentRequest_
import com.likeminds.internalsdk.comment.model._GetCommentResponse_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentReceiver @Inject constructor(
    private val commentNetworkApi: CommentNetworkApi
) {

    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse> {
        val postId = request.postId!!
        val newRequest = request.toBuilder().postId(null).build()
        return commentNetworkApi.addComment(postId, newRequest)
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
}