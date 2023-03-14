package com.likeminds.likemindsfeed.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class PostClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().postComponent()?.inject(this)
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPostRequest - client request model to fetch post
     * @return GetPostResponse - GetPostResponse model for getPostRequest
     */
    suspend fun getPost(getPostRequest: GetPostRequest): LMResponse<GetPostResponse> {
        // builds internal request model
        val request = _GetPostRequest_.Builder().postId(getPostRequest.postId)
            .page(getPostRequest.page)
            .pageSize(getPostRequest.pageSize)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.getPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertGetPostAPIResponse(body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param addPostRequest - client request model to add post
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun addPost(addPostRequest: AddPostRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _AddPostRequest_.Builder().text(addPostRequest.text)
            .attachments(addPostRequest.attachments)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.addPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPostLikesRequest - client request model to get likes data on the post
     * @return GetPostLikesResponse - GetPostLikesResponse model for getPostLikesRequest
     */
    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): LMResponse<GetPostLikesResponse> {
        // builds internal request model
        val request = _GetPostLikesRequest_.Builder().postId(getPostLikesRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.getPostLikes(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return ModelConverter.convertGetPostLikesAPIResponse(body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param deletePostRequest - client request model to delete the post
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun deletePost(deletePostRequest: DeletePostRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _DeletePostRequest_.Builder()
            .deleteReason(deletePostRequest.deleteReason)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.deletePost(deletePostRequest.postId, request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param likePostRequest - client request model to like the post
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun likePost(likePostRequest: LikePostRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _LikePostRequest_.Builder().postId(likePostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.likePost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param savePostRequest - client request model to save the post
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun savePost(savePostRequest: SavePostRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _SavePostRequest_.Builder().postId(savePostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.savePost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param pinPostRequest - client request model to pin the post
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun pinPost(pinPostRequest: PinPostRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _PinPostRequest_.Builder().postId(pinPostRequest.postId)
            .build()
        val api = collabmatesSDK.postApi()
        // calls api and processes the response accordingly
        return when (val response = api.pinPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }
}