package com.likeminds.likemindsfeed.post

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class PostClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().postComponent()?.inject(this)
    }

    suspend fun getPost(getPostRequest: GetPostRequest): GetPostResponse {
        val request = _GetPostRequest_.Builder().postId(getPostRequest.postId)
            .page(getPostRequest.page)
            .pageSize(getPostRequest.pageSize)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.getPost(request)) {
            is NetworkResponse.Error -> {
                GetPostResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertGetPostResponse(body)
            }
        }
    }

    suspend fun addPost(addPostRequest: AddPostRequest): BaseResponse {
        val request = _AddPostRequest_.Builder().text(addPostRequest.text)
            .attachments(addPostRequest.attachments)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.addPost(request)) {
            is NetworkResponse.Error -> {
                BaseResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return BaseResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): GetPostLikesResponse {
        val request = _GetPostLikesRequest_.Builder().postId(getPostLikesRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.getPostLikes(request)) {
            is NetworkResponse.Error -> {
                GetPostLikesResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertGetPostLikesResponse(body)
            }
        }
    }

    suspend fun deletePost(deletePostRequest: DeletePostRequest): BaseResponse {
        val request = _DeletePostRequest_.Builder().postId(deletePostRequest.postId)
            .deleteReason(deletePostRequest.deleteReason)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.deletePost(request)) {
            is NetworkResponse.Error -> {
                BaseResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return BaseResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    suspend fun likePost(likePostRequest: LikePostRequest): BaseResponse {
        val request = _LikePostRequest_.Builder().postId(likePostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.likePost(request)) {
            is NetworkResponse.Error -> {
                BaseResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return BaseResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    suspend fun savePost(savePostRequest: SavePostRequest): BaseResponse {
        val request = _SavePostRequest_.Builder().postId(savePostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.savePost(request)) {
            is NetworkResponse.Error -> {
                BaseResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return BaseResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    suspend fun pinPost(pinPostRequest: PinPostRequest): BaseResponse {
        val request = _PinPostRequest_.Builder().postId(pinPostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.pinPost(request)) {
            is NetworkResponse.Error -> {
                BaseResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return BaseResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }
}