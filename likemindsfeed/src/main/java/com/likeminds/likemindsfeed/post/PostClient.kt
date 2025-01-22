package com.likeminds.likemindsfeed.post

import com.likeminds.internalsdk.post.model.*
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.post.model.*
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class PostClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().postComponent()?.inject(this)
    }

    private val postApi by lazy {
        feedSDK.getPostApi()
    }

    private val postDao by lazy {
        feedSDK.getPostWithAttachmentsDao()
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

        // calls api and processes the response accordingly
        return when (val response = postApi.getPost(request)) {
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
     * validates [getPostRequest]
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
        val request = _AddPostRequest_.Builder()
            .text(addPostRequest.text)
            .onBehalfOfUUID(addPostRequest.onBehalfOfUUID)
            .heading(addPostRequest.heading)
            .attachments(ModelConverter.createAttachments(addPostRequest.attachments))
            .tempId(addPostRequest.tempId)
            .topicIds(addPostRequest.topicIds)
            .build()

        // calls api and processes the response accordingly
        return when (val response = postApi.addPost(request)) {
            is NetworkResponse.Error -> {
                //delete the post from DB
                deletePostInDB(addPostRequest.tempId)

                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body

                //update db
                body.data?.let { addPostResponse ->
                    updatePostInDB(addPostResponse)
                }

                ModelConverter.convertAddPostAPIResponse(body)
            }
        }
    }

    /**
     * validates [addPostRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddPostRequest(addPostRequest: AddPostRequest) {
        if (addPostRequest.text.isNullOrEmpty()
            && addPostRequest.attachments.isNullOrEmpty()
            && addPostRequest.heading.isNullOrEmpty()
        ) {
            RequestUtils.throwException("text or heading or attachments")
        }

        //check for individual meta value
        val attachment = addPostRequest.attachments?.firstOrNull() ?: return
        val attachmentType = attachment.attachmentType
        val attachmentMeta = attachment.attachmentMeta
        when (attachmentType) {
            AttachmentType.POLL -> {
                when {
                    attachmentMeta.title.isNullOrEmpty() -> {
                        RequestUtils.throwException("poll question")
                    }

                    attachmentMeta.expiryTime == null -> {
                        RequestUtils.throwException("poll expiry time")
                    }

                    attachmentMeta.pollOptions.isNullOrEmpty() -> {
                        RequestUtils.throwException("poll options")
                    }
                }
            }

            else -> {}
        }
    }

    private suspend fun updatePostInDB(addPostResponse: _AddPostResponse_) {
        val post = addPostResponse.post
        val temporaryPostId = post.tempId
        val postId = post.id

        //update isPosted and postId in Post table
        postDao.updateIsPosted(
            temporaryPostId,
            postId,
            true
        )

        //update postId in Attachment table
        postDao.updatePostIdInAttachments(postId, temporaryPostId)
    }

    private suspend fun deletePostInDB(temporaryId: String?) {
        //deletes the post from the post table
        postDao.deletePostByTempId(temporaryId)

        //deletes all the attachments with [temporaryId]
        postDao.deleteAttachmentsByPostTempId(temporaryId)
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param editPostRequest - client request model to edit post
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return EditPostResponse- EditPostResponse model for editPostRequest
     */
    suspend fun editPost(editPostRequest: EditPostRequest): LMResponse<EditPostResponse> {
        // validates the client request
        RequestUtils.validate()
        validateEditPostRequest(editPostRequest)

        // builds internal request model
        val request = _EditPostRequest_.Builder()
            .postId(editPostRequest.postId)
            .text(editPostRequest.text)
            .heading(editPostRequest.heading)
            .entityId(editPostRequest.entityId)
            .attachments(ModelConverter.createAttachments(editPostRequest.attachments))
            .topicIds(editPostRequest.topicIds)
            .build()

        // calls api and processes the response accordingly
        return when (val response = postApi.editPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                val body = response.body
                ModelConverter.convertEditPostAPIResponse(body)
            }
        }
    }

    /**
     * validates [editPostRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateEditPostRequest(editPostRequest: EditPostRequest) {
        if (editPostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }

        if (editPostRequest.text.isNullOrEmpty()
            && editPostRequest.attachments.isNullOrEmpty()
            && editPostRequest.heading.isNullOrEmpty()
        ) {
            RequestUtils.throwException("text or attachments or heading")
        }
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
        val request = _GetPostLikesRequest_.Builder()
            .postId(getPostLikesRequest.postId)
            .page(getPostLikesRequest.page)
            .pageSize(getPostLikesRequest.pageSize)
            .build()
        // calls api and processes the response accordingly
        return when (val response = postApi.getPostLikes(request)) {
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
     * validates [getPostLikesRequest]
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
            .postId(deletePostRequest.postId)
            .deleteReason(deletePostRequest.deleteReason)
            .build()
        // calls api and processes the response accordingly
        return when (val response = postApi.deletePost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [deletePostRequest]
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
        val request = _LikePostRequest_.Builder()
            .postId(likePostRequest.postId)
            .build()

        // calls api and processes the response accordingly
        return when (val response = postApi.likePost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [likePostRequest]
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
        val request = _SavePostRequest_.Builder()
            .postId(savePostRequest.postId)
            .build()

        // calls api and processes the response accordingly
        return when (val response = postApi.savePost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [savePostRequest]
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
        val request = _PinPostRequest_.Builder()
            .postId(pinPostRequest.postId)
            .build()

        // calls api and processes the response accordingly
        return when (val response = postApi.pinPost(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [pinPostRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validatePinPostRequest(pinPostRequest: PinPostRequest) {
        if (pinPostRequest.postId.isEmpty()) {
            RequestUtils.throwException("postId")
        }
    }

    /**
     * Converts client request model to db model and add in the db
     * @param addTemporaryPostRequest - client request model to add a temporary post in DB
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun addTemporaryPost(addTemporaryPostRequest: AddTemporaryPostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateAddTemporaryPostRequest(addTemporaryPostRequest)

        val postEntity = ModelConverter.createPostEntity(
            addTemporaryPostRequest.post,
            addTemporaryPostRequest.postThumbnail,
            addTemporaryPostRequest.workerUUID
        )

        val attachmentEntities = ModelConverter.createAttachmentEntities(
            addTemporaryPostRequest.post.tempId ?: "",
            addTemporaryPostRequest.post.attachments
        )

        val topicEntities = ModelConverter.createTopicEntities(
            addTemporaryPostRequest.post.tempId ?: "",
            addTemporaryPostRequest.topics
        )

        postDao.insertPostWithAttachments(postEntity, attachmentEntities, topicEntities)

        return LMResponse(success = true)
    }

    /**
     * Converts client request model to db model and add in the db
     * @param updatePostWorkerUUIDRequest - client request model to update post worker uuid in db
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun updatePostWorkerUUID(updatePostWorkerUUIDRequest: UpdatePostWorkerUUIDRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateUpdatePostWorkerUUIDRequest(updatePostWorkerUUIDRequest)

        postDao.updateUploadWorkerUUID(
            updatePostWorkerUUIDRequest.temporaryId,
            updatePostWorkerUUIDRequest.workerUUID
        )

        return LMResponse(success = true)
    }

    /**
     * validates [updatePostWorkerUUIDRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateUpdatePostWorkerUUIDRequest(updatePostWorkerUUIDRequest: UpdatePostWorkerUUIDRequest) {
        if (updatePostWorkerUUIDRequest.temporaryId.isEmpty()) {
            RequestUtils.throwException("temporaryId")
        }

        if (updatePostWorkerUUIDRequest.workerUUID.isEmpty()) {
            RequestUtils.throwException("workerUUID")
        }
    }

    /**
     * validates [addTemporaryPostRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validateAddTemporaryPostRequest(addTemporaryPostRequest: AddTemporaryPostRequest) {
        if (addTemporaryPostRequest.post.text.isEmpty()
            && addTemporaryPostRequest.post.attachments.isNullOrEmpty()
            && addTemporaryPostRequest.post.heading.isNullOrEmpty()
        ) {
            RequestUtils.throwException("text or attachments or heading")
        }
    }

    /**
     * Get the current uploading post from db model Convert it to client model
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<GetCurrentUploadingPostResponse> - GetCurrentUploadingPostResponse
     */
    suspend fun getCurrentUploadingPost(): LMResponse<GetCurrentUploadingPostResponse> {
        // validates the client request
        RequestUtils.validate()

        val postWithAttachments = postDao.getLatestPostWithAttachments()
        return if (postWithAttachments == null) {
            LMResponse(
                success = false,
                errorMessage = "There is no post uploading right now."
            )
        } else {
            ModelConverter.convertGetCurrentUploadingPostResponse(postWithAttachments)
        }
    }

    /**
     * Get the temporary post from db model Convert it to client model
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<GetTemporaryPostResponse> - GetTemporaryPostResponse
     */
    suspend fun getTemporaryPost(temporaryId: String): LMResponse<GetTemporaryPostResponse> {
        // validates the client request
        RequestUtils.validate()

        val postWithAttachments = postDao.getPostWithAttachments(temporaryId)

        return if (postWithAttachments == null) {
            LMResponse(
                success = false,
                errorMessage = "Post with respect to temporary id: $temporaryId not found."
            )
        } else {
            ModelConverter.convertGetTemporaryPostResponse(postWithAttachments)
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param postSeenRequest - client request model to mark post as seen
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated or required properties not provided
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun postSeen(postSeenRequest: PostSeenRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validatePostSeenRequest(postSeenRequest)

        val _postSeenRequest_ = _PostSeenRequest_.Builder()
            .seenPostIds(postSeenRequest.seenPostIds)
            .build()

        return when (val response = postApi.postSeen(_postSeenRequest_)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }

            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [postSeenRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun validatePostSeenRequest(postSeenRequest: PostSeenRequest) {
        if (postSeenRequest.seenPostIds.isEmpty()) {
            RequestUtils.throwException("seenPostIds")
        }
    }

    suspend fun insertSeenPosts(insertSeenPostRequest: InsertSeenPostRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        validateInsertSeenPostRequest(insertSeenPostRequest)


    }


    private fun validateInsertSeenPostRequest(postSeenRequest: InsertSeenPostRequest) {
        if (postSeenRequest.seenPosts.isEmpty()) {
            RequestUtils.throwException("seenPosts")
        }
    }
}