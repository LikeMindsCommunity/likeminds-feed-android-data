package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface NotificationFeedApi {

    suspend fun getNotificationFeed(
        request: _GetNotificationFeedRequest_
    ): NetworkResponse<_GetNotificationFeedResponse_>
}