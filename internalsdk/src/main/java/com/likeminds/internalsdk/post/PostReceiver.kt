package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostReceiver @Inject constructor(
    private val postNetworkApi: PostNetworkApi
) {
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<APIResponse<_AddPostResponse_>> {
        return postNetworkApi.addPost(request)
    }

    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<APIResponse<_GetPostResponse_>> {
        return postNetworkApi.getPost(
            request.postId,
            request.page,
            request.pageSize
        )
    }

    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<APIResponse<_GetPostLikesResponse_>> {
        return postNetworkApi.getPostLikes(
            request.postId,
            request.page,
            request.pageSize
        )
    }

    suspend fun deletePost(
        request: _DeletePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        val postId = request.postId ?: ""
        val newRequest = request.toBuilder().postId(null).build()

        return postNetworkApi.deletePost(
            postId,
            newRequest
        )
    }

    suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postNetworkApi.likePost(
            request.postId
        )
    }

    suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postNetworkApi.savePost(
            request.postId
        )
    }

    suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postNetworkApi.pinPost(
            request.postId
        )
    }
}