package com.likeminds.internalsdk.universalfeed

import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface UniversalFeedApi {

    suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<_GetFeedResponse_>
}