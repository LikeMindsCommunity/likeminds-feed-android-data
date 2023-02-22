package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface PostNetworkApi {

    @POST("feed/post")
    suspend fun addPost(
        @Body addPostRequest: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_>

    @GET("feed/post/{post_id}")
    suspend fun getPost(
        @Path("post_id") postId: String,
        @Query("page") page: Int?,
        @Query("page_size") pageSize: Int?
    ): NetworkResponse<_GetPostResponse_>

    @GET("feed/post/{post_id}/like")
    suspend fun getPostLikes(
        @Path("post_id") postId: String,
    ): NetworkResponse<_GetPostLikesResponse_>

    @DELETE("feed/post/{post_id}")
    suspend fun deletePost(
        @Path("post_id") postId: String,
        @Body deleteReason: _DeletePostRequest_
    ): NetworkResponse<_DeletePostResponse_>
}