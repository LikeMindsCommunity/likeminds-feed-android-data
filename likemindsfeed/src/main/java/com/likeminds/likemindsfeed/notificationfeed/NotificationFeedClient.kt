package com.likeminds.likemindsfeed.notificationfeed

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.universalfeed.model._GetFeedRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedRequest
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedResponse
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedResponse
import javax.inject.Inject

class NotificationFeedClient @Inject constructor() {

    init {
        attachDagger()
    }

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    private fun attachDagger() {
        LikeMindsFeedApplication.getInstance().notificationFeedComponent()?.inject(this)
    }

    suspend fun getNotificationFeed(getNotificationFeedRequest: GetNotificationFeedRequest): GetNotificationFeedResponse {
        val request = _GetNotificationFeedRequest_.Builder()
            .page(getNotificationFeedRequest.page)
            .pageSize(getNotificationFeedRequest.pageSize)
            .build()
        val api = collabmatesSDK.getNotificationFeedApi()
        return when (val response = api.getNotificationFeed(request)) {
            is NetworkResponse.Error -> {
                GetNotificationFeedResponse(
                    success = false,
                    errorMessage = response.body.errorMessage,
                    null
                )
            }
            is NetworkResponse.Success -> {
                //TODO: change data in notification feed
                GetNotificationFeedResponse(
                    success = false,
                    errorMessage = response.body.errorMessage,
                    ""
                )
            }
        }
    }
}