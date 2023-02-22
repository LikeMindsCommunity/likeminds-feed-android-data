package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model._AddPostRequest_
import com.likeminds.internalsdk.post.model._AddPostResponse_
import com.likeminds.internalsdk.post.model._GetPostLikesResponse_
import com.likeminds.internalsdk.post.model._GetPostResponse_
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
}