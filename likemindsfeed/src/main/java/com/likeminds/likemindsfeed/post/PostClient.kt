package com.likeminds.likemindsfeed.post

import com.google.gson.Gson
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.post.model.Attachment
import com.likeminds.internalsdk.post.model._AddPostRequest_
import com.likeminds.internalsdk.post.model._GetPostRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.AddPostResponse
import com.likeminds.likemindsfeed.post.model.GetPostRequest
import com.likeminds.likemindsfeed.post.model.GetPostResponse
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

    suspend fun addPost(addPostRequest: AddPostRequest): AddPostResponse {
        if (hasUploadAbleAttachments(addPostRequest.attachments)) {
            startMediaUploadWorker(addPostRequest.attachments!!)
        }
        val request = _AddPostRequest_.Builder().text(addPostRequest.text)
            .attachments(addPostRequest.attachments)
            .build()
        val api = collabmatesSDK.postApi()
        return when (val response = api.addPost(request)) {
            is NetworkResponse.Error -> {
                AddPostResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return AddPostResponse(
                    success = response.body.success,
                    null
                )
            }
        }
    }

    // checks if there are any attachments to upload or not
    private fun hasUploadAbleAttachments(attachments: List<Attachment>?): Boolean {
        // no upload-able attachments if the attachment is of type link.
        if (attachments.isNullOrEmpty() || (attachments.size == 1 && attachments.first().attachmentType == 4)) return false
        return true
    }

    private fun startMediaUploadWorker(attachments: List<Attachment>) {
        val jsonAttachment = Gson().toJson(attachments)

    }
}