package com.likeminds.likemindsfeed.moderation

import com.likeminds.internalsdk.moderation.model._GetReportTagsRequest_
import com.likeminds.internalsdk.moderation.model._PostReportRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsResponse
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import javax.inject.Inject

class ModerationClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().moderationComponent()?.inject(this)
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getReportTagsRequest - client request model to fetch report tags
     * @return GetReportTagsResponse - GetReportTagsResponse model for getReportTagsRequest
     */
    suspend fun getReportTags(getReportTagsRequest: GetReportTagsRequest): LMResponse<GetReportTagsResponse> {
        // builds internal request model
        val request = _GetReportTagsRequest_.Builder()
            .type(getReportTagsRequest.type)
            .build()
        val api = collabmatesSDK.moderationApi()
        // calls api and processes the response accordingly
        return when (val response = api.getReportTags(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetReportTagsAPIResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param postReportRequest - client request model to post report on the entity
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun postReport(postReportRequest: PostReportRequest): LMResponse<Nothing> {
        // builds internal request model
        val request = _PostReportRequest_.Builder()
            .entityId(postReportRequest.entityId)
            .entityCreatorId(postReportRequest.entityCreatorId)
            .entityType(postReportRequest.entityType)
            .link(postReportRequest.link)
            .tagId(postReportRequest.tagId)
            .reason(postReportRequest.reason)
            .build()
        val api = collabmatesSDK.moderationApi()
        // calls api and processes the response accordingly
        return when (val response = api.postReport(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    response.body.success,
                    null
                )
            }
        }
    }
}