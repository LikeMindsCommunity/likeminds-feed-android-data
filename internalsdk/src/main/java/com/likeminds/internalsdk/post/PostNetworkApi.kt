package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.*

interface PostNetworkApi {

    @POST("feed/post")
    suspend fun addPost(
        @Body addPostRequest: _AddPostRequest_
    ): NetworkResponse<BaseResponse>

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

    @HTTP(method = "DELETE", path = "feed/post/{post_id}", hasBody = true)
    suspend fun deletePost(
        @Path("post_id") postId: String,
        @Body deleteReason: _DeletePostRequest_
    ): NetworkResponse<BaseResponse>

    @PUT("feed/post/{post_id}/like")
    suspend fun likePost(
        @Path("post_id") postId: String,
    ): NetworkResponse<BaseResponse>

    @PUT("feed/post/{post_id}/save")
    suspend fun savePost(
        @Path("post_id") postId: String,
    ): NetworkResponse<BaseResponse>

    @PUT("feed/post/{post_id}/pin")
    suspend fun pinPost(
        @Path("post_id") postId: String,
    ): NetworkResponse<BaseResponse>
}