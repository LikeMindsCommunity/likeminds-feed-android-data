package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostApiImpl @Inject constructor(
    private val postReceiver: PostReceiver
) : PostApi {

    override suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<APIResponse<_AddPostResponse_>> {
        return postReceiver.addPost(request)
    }

    override suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<APIResponse<_GetPostResponse_>> {
        return postReceiver.getPost(request)
    }

    override suspend fun getPostLikes(
        request: _GetPostLikesRequest_
    ): NetworkResponse<APIResponse<_GetPostLikesResponse_>> {
        return postReceiver.getPostLikes(request)
    }

    override suspend fun deletePost(
        postId: String,
        request: _DeletePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postReceiver.deletePost(postId, request)
    }

    override suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postReceiver.likePost(request)
    }

    override suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postReceiver.savePost(request)
    }

    override suspend fun pinPost(
        request: _PinPostRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return postReceiver.pinPost(request)
    }
}