package com.likeminds.internalsdk.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class UniversalFeedReceiver @Inject constructor(
    private val universalFeedNetworkApi: UniversalFeedNetworkApi
) {
    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<_GetFeedResponse_> {
        return universalFeedNetworkApi.getFeed(
            request.page,
            request.pageSize
        )
    }
}