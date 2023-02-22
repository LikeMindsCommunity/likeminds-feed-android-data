package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PostApi {

    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_>

    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_>

    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<_GetPostLikesResponse_>
}