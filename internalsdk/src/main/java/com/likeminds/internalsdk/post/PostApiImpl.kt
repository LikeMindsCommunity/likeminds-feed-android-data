package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostApiImpl @Inject constructor(
    private val postReceiver: PostReceiver
) : PostApi {

    override suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_> {
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
    ): NetworkResponse<_DeletePostResponse_> {
        return postReceiver.deletePost(request)
    }

    override suspend fun likePost(
        request: _LikePostRequest_
    ): NetworkResponse<_LikePostResponse_> {
        return postReceiver.likePost(request)
    }

    override suspend fun savePost(
        request: _SavePostRequest_
    ): NetworkResponse<_SavePostResponse_> {
        return postReceiver.savePost(request)
    }
}