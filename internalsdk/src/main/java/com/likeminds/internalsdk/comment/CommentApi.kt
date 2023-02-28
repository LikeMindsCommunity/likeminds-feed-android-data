package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommentApi {

    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_>

    suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<_GetCommentLikesResponse_>

    suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun deleteComment(
        request_: _DeleteCommentRequest_
    ): NetworkResponse<BaseResponse>
}