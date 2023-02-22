package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model._AddPostRequest_
import com.likeminds.internalsdk.post.model._AddPostResponse_
import com.likeminds.internalsdk.post.model._GetPostRequest_
import com.likeminds.internalsdk.post.model._GetPostResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface PostApi {

    suspend fun addPost(
        request: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_>

    suspend fun getPost(
        request: _GetPostRequest_
    ): NetworkResponse<_GetPostResponse_>
}