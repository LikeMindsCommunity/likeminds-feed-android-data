package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PostApi {

    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_>

    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<_GetPostLikesResponse_>

    suspend fun deletePost(
        postId: String,
        request: _DeletePostRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<BaseResponse>

    suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<BaseResponse>
}