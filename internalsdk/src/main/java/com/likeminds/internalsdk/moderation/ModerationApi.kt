package com.likeminds.internalsdk.moderation

import com.likeminds.internalsdk.moderation.model._GetReportTagsRequest_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.moderation.model._PostReportRequest_
import com.likeminds.internalsdk.utils.retrofit.model.BaseResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface ModerationApi {

    suspend fun getReportTags(
        request: _GetReportTagsRequest_
    ): NetworkResponse<_GetReportTagsResponse_>

    suspend fun postReport(
        request: _PostReportRequest_
    ): NetworkResponse<BaseResponse>
}