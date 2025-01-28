package com.likeminds.internalsdk.feed

import com.likeminds.internalsdk.feed.model.*
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

    override suspend fun getPersonalisedFeed(
        request: _GetPersonalisedFeedRequest_
    ): NetworkResponse<APIResponse<_GetPersonalisedFeedResponse_>> {
        return feedReceiver.getPersonalisedFeed(request)
    }
}