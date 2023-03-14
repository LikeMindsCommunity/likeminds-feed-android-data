package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommentApi {

    // api to add comment to the post
    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>

    // api to add comment to the post
    // TODO:
    suspend fun addReplyOnComment(
        request: _AddCommentRequest_
    ): NetworkResponse<BaseResponse>

    // api to fetch the comment and its paginated replies
    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<_GetCommentResponse_>

    // api to fetch the comment's like data
    suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<_GetCommentLikesResponse_>

    // api to like the comment
    suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<BaseResponse>

    // api to delete the comment
    suspend fun deleteComment(
        request_: _DeleteCommentRequest_
    ): NetworkResponse<BaseResponse>
}