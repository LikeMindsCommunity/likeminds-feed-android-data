package com.likeminds.likemindsfeed.moderation

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.moderation.model._GetReportTagsRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class ModerationClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().moderationComponent()?.inject(this)
    }

    suspend fun getReportTags(getReportTagsRequest: GetReportTagsRequest): GetReportTagsResponse {
        val request = _GetReportTagsRequest_.Builder()
            .type(getReportTagsRequest.type)
            .build()
        val api = collabmatesSDK.moderationApi()
        return when (val response = api.getReportTags(request)) {
            is NetworkResponse.Error -> {
                GetReportTagsResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                val body = response.body
                return GetReportTagsResponse(
                    body.success,
                    body.errorMessage,
                    body.data,
                )
            }
        }
    }
}