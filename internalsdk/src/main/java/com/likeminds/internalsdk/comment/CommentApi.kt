package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface CommentApi {

    // api to add comment to the post
    suspend fun addComment(
        request: _AddCommentRequest_
    ): NetworkResponse<APIResponse<_AddCommentResponse_>>

    // api to add reply on the comment
    suspend fun replyComment(
        request: _ReplyCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to fetch the comment and its paginated replies
    suspend fun getComment(
        request: _GetCommentRequest_
    ): NetworkResponse<APIResponse<_GetCommentResponse_>>

    // api to fetch the comment's like data
    suspend fun getCommentLikes(
        request: _GetCommentLikesRequest_
    ): NetworkResponse<APIResponse<_GetCommentLikesResponse_>>

    // api to like the comment
    suspend fun likeComment(
        request: _LikeCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to delete the comment
    suspend fun deleteComment(
        request: _DeleteCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>
}