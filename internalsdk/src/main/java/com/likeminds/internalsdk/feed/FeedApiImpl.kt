package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model._GetFeedRequest_
import com.likeminds.internalsdk.feed.model._GetFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class FeedApiImpl @Inject constructor(
    private val feedReceiver: FeedReceiver
) : FeedApi {

    override suspend fun getFeed(
        request: _GetFeedRequest_
    ): NetworkResponse<APIResponse<_GetFeedResponse_>> {
        return feedReceiver.getFeed(request)
    }
}