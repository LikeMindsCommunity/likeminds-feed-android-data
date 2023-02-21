package com.likeminds.internalsdk.post

import com.likeminds.internalsdk.post.model._AddPostRequest_
import com.likeminds.internalsdk.post.model._AddPostResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PostNetworkApi {

    @POST("feed/post")
    suspend fun addPost(
        @Body addPostRequest: _AddPostRequest_
    ): NetworkResponse<_AddPostResponse_>
}