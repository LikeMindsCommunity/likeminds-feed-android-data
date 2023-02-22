package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostApiImpl @Inject constructor(
    private val postReceiver: PostReceiver
) : PostApi {

    override suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<BaseResponse> {
        return postReceiver.addPost(request)
    }

    override suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_> {
        return postReceiver.getPost(request)
    }

    override suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<_GetPostLikesResponse_> {
        return postReceiver.getPostLikes(request)
    }

    override suspend fun deletePost(
        request: _DeletePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postReceiver.deletePost(request)
    }

    override suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postReceiver.likePost(request)
    }

    override suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<BaseResponse> {
        return postReceiver.savePost(request)
    }

    override suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<BaseResponse> {
        return postReceiver.pinPost(request)
    }
}