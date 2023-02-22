package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model._AddPostRequest_
import com.likeminds.internalsdk.post.model._AddPostResponse_
import com.likeminds.internalsdk.post.model._GetPostRequest_
import com.likeminds.internalsdk.post.model._GetPostResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class PostReceiver @Inject constructor(
    private val postNetworkApi: PostNetworkApi
) {
    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_> {
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
}