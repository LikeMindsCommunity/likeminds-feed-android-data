package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostReceiver @Inject constructor(
    private val postNetworkApi: PostNetworkApi
) {
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<BaseResponse> {
        return postNetworkApi.addPost(request)
    }

    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_> {
        return postNetworkApi.getPost(
            request.postId,
            request.page,
            request.pageSize
        )
    }

    suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<_GetPostLikesResponse_> {
        return postNetworkApi.getPostLikes(
            request.postId
        )
    }

    suspend fun deletePost(
        request: _DeletePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postNetworkApi.deletePost(
            request.postId,
            request
        )
    }

    suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postNetworkApi.likePost(
            request.postId
        )
    }

    suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postNetworkApi.savePost(
            request.postId
        )
    }

    suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<BaseResponse> {
        return postNetworkApi.pinPost(
            request.postId
        )
    }
}