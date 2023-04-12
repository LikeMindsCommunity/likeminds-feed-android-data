package com.likeminds.internalsdk.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class UniversalFeedApiImpl @Inject constructor(
    private val universalFeedReceiver: UniversalFeedReceiver
) : UniversalFeedApi {

    override suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>> {
        return universalFeedReceiver.getFeed(request)
    }
}