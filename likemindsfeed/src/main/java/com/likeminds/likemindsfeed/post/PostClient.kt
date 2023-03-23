package com.likeminds.likemindsfeed.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.sdk.ModelConverter.createAttachments
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class PostClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().postComponent()?.inject(this)
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPostRequest - client request model to fetch post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return GetPostResponse - GetPostResponse model for getPostRequest
     */
    suspend fun getPost(getPostRequest: GetPostRequest): LMResponse<GetPostResponse> {
        // validates the client request
        RequestUtils.validate()
        validateGetPostRequest(getPostRequest)

        // builds internal request model
        val request = _GetPostRequest_.Builder().postId(getPostRequest.postId)
            .page(getPostRequest.page)
            .pageSize(getPostRequest.pageSize)
            .build()
        val api = collabmatesSDK.getPostApi()
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
     * validates getPostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateGetPostRequest(getPostRequest: GetPostRequest) {
        if (getPostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param addPostRequest - client request model to add post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return AddPostResponse- AddPostResponse model for addPostRequest
     */
    suspend fun addPost(addPostRequest: AddPostRequest): LMResponse<AddPostResponse> {
        // validates the client request
        RequestUtils.validate()
        validateAddPostRequest(addPostRequest)

        // builds internal request model
        val request = _AddPostRequest_.Builder().text(addPostRequest.text)
            .attachments(createAttachments(addPostRequest.attachments))
            .build()
        val api = collabmatesSDK.getPostApi()
        // calls api and processes the response accordingly
        return when (val response = api.addPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                ModelConverter.convertAddPostAPIResponse(body)
            }
        }
    }

    /**
     * validates addPostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddPostRequest(addPostRequest: AddPostRequest) {
        if (addPostRequest.text.isNullOrEmpty() && addPostRequest.attachments.isNullOrEmpty()) {
            RequestUtils.throwException("text")
        }
    }

    // checks if there are any attachments to upload or not
    private fun hasUploadAbleAttachments(attachments: List<_Attachment_>?): Boolean {
        // no upload-able attachments if the attachment is of type link.
        if (attachments.isNullOrEmpty() || (attachments.size == 1 && attachments.first().attachmentType == 4)) return false
        return true
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getPostLikesRequest - client request model to get likes data on the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return GetPostLikesResponse - GetPostLikesResponse model for getPostLikesRequest
     */
    suspend fun getPostLikes(getPostLikesRequest: GetPostLikesRequest): LMResponse<GetPostLikesResponse> {
        // validates the client request
        RequestUtils.validate()
        validateGetPostLikesRequest(getPostLikesRequest)

        // builds internal request model
        val request = _GetPostLikesRequest_.Builder().postId(getPostLikesRequest.postId)
            .page(getPostLikesRequest.page)
            .pageSize(getPostLikesRequest.pageSize)
            .build()
        val api = collabmatesSDK.getPostApi()
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
     * validates getPostLikesRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateGetPostLikesRequest(getPostLikesRequest: GetPostLikesRequest) {
        if (getPostLikesRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param deletePostRequest - client request model to delete the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun deletePost(deletePostRequest: DeletePostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateDeletePostRequest(deletePostRequest)

        // builds internal request model
        val request = _DeletePostRequest_.Builder()
            .deleteReason(deletePostRequest.deleteReason)
            .build()
        val api = collabmatesSDK.getPostApi()
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
     * validates deletePostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateDeletePostRequest(deletePostRequest: DeletePostRequest) {
        if (deletePostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param likePostRequest - client request model to like the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun likePost(likePostRequest: LikePostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateLikePostRequest(likePostRequest)

        // builds internal request model
        val request = _LikePostRequest_.Builder().postId(likePostRequest.postId)
            .build()
        val api = collabmatesSDK.getPostApi()
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
     * validates likePostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateLikePostRequest(likePostRequest: LikePostRequest) {
        if (likePostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param savePostRequest - client request model to save the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun savePost(savePostRequest: SavePostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateSavePostRequest(savePostRequest)

        // builds internal request model
        val request = _SavePostRequest_.Builder().postId(savePostRequest.postId)
            .build()
        val api = collabmatesSDK.getPostApi()
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
     * validates savePostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateSavePostRequest(savePostRequest: SavePostRequest) {
        if (savePostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param pinPostRequest - client request model to pin the post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun pinPost(pinPostRequest: PinPostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validatePinPostRequest(pinPostRequest)

        // builds internal request model
        val request = _PinPostRequest_.Builder().postId(pinPostRequest.postId)
            .build()
        val api = collabmatesSDK.getPostApi()
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

    /**
     * validates pinPostRequest
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validatePinPostRequest(pinPostRequest: PinPostRequest) {
        if (pinPostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }
}