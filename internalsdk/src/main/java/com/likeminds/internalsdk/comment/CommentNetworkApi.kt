package com.likeminds.internalsdk.comment

import com.likeminds.internalsdk.comment.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface CommentNetworkApi {

    @POST("feed/post/{post_id}/comment")
    suspend fun addComment(
        @Path("post_id") postId: String,
        @Body addCommentRequest: _AddCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    @POST("feed/post/{post_id}/comment/{comment_id}/comment")
    suspend fun addReplyOnComment(
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Body addCommentRequest: _AddReplyOnCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    @GET("feed/post/{post_id}/comment/{comment_id}")
    suspend fun getComment(
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Query("page") page: Int?,
        @Query("page_size") pageSize: Int?,
    ): NetworkResponse<APIResponse<_GetCommentResponse_>>

    @GET("feed/post/{post_id}/comment/{comment_id}/like")
    suspend fun getCommentLikes(
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Query("page") page: Int?,
        @Query("page_size") pageSize: Int?,
    ): NetworkResponse<APIResponse<_GetCommentLikesResponse_>>

    @PUT("feed/post/{post_id}/comment/{comment_id}/like")
    suspend fun likeComment(
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String
    ): NetworkResponse<APIResponse<Nothing>>

    @HTTP(method = "DELETE", path = "feed/post/{post_id}/comment/{comment_id}", hasBody = true)
    suspend fun deleteComment(
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Body deleteCommentRequest: _DeleteCommentRequest_
    ): NetworkResponse<APIResponse<Nothing>>
}