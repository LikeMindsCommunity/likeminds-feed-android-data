package com.likeminds.internalsdk.moderation

import com.likeminds.internalsdk.moderation.model._GetReportTagsRequest_
import com.likeminds.internalsdk.moderation.model._GetReportTagsResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class ModerationApiImpl @Inject constructor(
    private val moderationReceiver: ModerationReceiver
) : ModerationApi {

    override suspend fun getReportTags(
        request: _GetReportTagsRequest_
    ): NetworkResponse<_GetReportTagsResponse_> {
        return moderationReceiver.getReportTags(request)
    }
}