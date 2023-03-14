package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PostApi {

    // api to add the post
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<BaseResponse>

    // api to fetch the post
    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_>

    // api to fetch likes data on the post
    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<_GetPostLikesResponse_>

    // api to delete the post
    suspend fun deletePost(
        postId: String,
        request: _DeletePostRequest_
    ): NetworkResponse<BaseResponse>

    // api to like the post
    suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<BaseResponse>

    // api to save the post
    suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<BaseResponse>

    // api to pin the post
    suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<BaseResponse>
}