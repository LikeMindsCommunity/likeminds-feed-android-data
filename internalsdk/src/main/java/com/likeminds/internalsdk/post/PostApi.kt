package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Body

interface PostApi {

    // api to add the post
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<APIResponse<_AddPostResponse_>>

    // api to edit the post
    suspend fun editPost(
        request: _EditPostRequest_
    ): NetworkResponse<APIResponse<_EditPostResponse_>>

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

    // api to mark post as seen
    suspend fun postSeen(
        @Body request: _PostSeenRequest_
    ): NetworkResponse<APIResponse<Nothing>>
}