package com.likeminds.likemindsfeed.moderation

import com.likeminds.internalsdk.moderation.model._GetReportTagsRequest_
import com.likeminds.internalsdk.moderation.model._PostReportRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.moderation.model.PostReportResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class ModerationClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
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
                return GetReportTagsResponse(
                    response.body.success,
                    null,
                    response.body.data,
                )
            }
        }
    }

    suspend fun postReport(postReportRequest: PostReportRequest): PostReportResponse {
        val request = _PostReportRequest_.Builder()
            .entityId(postReportRequest.entityId)
            .entityCreatorId(postReportRequest.entityCreatorId)
            .entityType(postReportRequest.entityType)
            .link(postReportRequest.link)
            .tagId(postReportRequest.tagId)
            .reason(postReportRequest.reason)
            .build()
        val api = collabmatesSDK.moderationApi()
        return when (val response = api.postReport(request)) {
            is NetworkResponse.Error -> {
                PostReportResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                return PostReportResponse(
                    response.body.success,
                    null
                )
            }
        }
    }
}