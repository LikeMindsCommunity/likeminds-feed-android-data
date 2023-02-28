package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class NotificationFeedApiImpl @Inject constructor(
    private val notificationFeedReceiver: NotificationFeedReceiver
) : NotificationFeedApi {

    override suspend fun getNotificationFeed(
        request: _GetNotificationFeedRequest_
    ): NetworkResponse<_GetNotificationFeedResponse_> {
        return notificationFeedReceiver.getNotificationFeed(request)
    }
}