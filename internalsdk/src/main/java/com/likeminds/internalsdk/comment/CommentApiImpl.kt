package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class CommentApiImpl @Inject constructor(
    private val commentReceiver: CommentReceiver
) : CommentApi {

    override suspend fun addComment(
        postId: String,
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse> {
        return commentReceiver.addComment(postId, request)
    }
}