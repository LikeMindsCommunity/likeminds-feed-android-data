package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PostApi {

    // api to add the post
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to fetch the post
    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<APIResponse<_GetPostResponse_>>

    // api to fetch likes data on the post
    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<APIResponse<_GetPostLikesResponse_>>

    // api to delete the post
    suspend fun deletePost(
        postId: String,
        request: _DeletePostRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to like the post
    suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to save the post
    suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to pin the post
    suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<APIResponse<Nothing>>
}