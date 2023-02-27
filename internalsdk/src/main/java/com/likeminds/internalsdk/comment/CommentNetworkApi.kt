package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model._AddCommentRequest_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentNetworkApi {

    @POST("feed/post/{post_id}/comment")
    suspend fun addComment(
        @Path("post_id") postId: String,
        @Body addCommentRequest: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>
}