package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.notificationfeed.model._GetUnreadNotificationCountResponse_
import com.likeminds.internalsdk.notificationfeed.model._MarkReadNotificationRequest_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class NotificationFeedApiImpl @Inject constructor(
    private val notificationFeedReceiver: NotificationFeedReceiver
) : NotificationFeedApi {

    override suspend fun getNotificationFeed(
        request: _GetNotificationFeedRequest_
    ): NetworkResponse<APIResponse<_GetNotificationFeedResponse_>> {
        return notificationFeedReceiver.getNotificationFeed(request)
    }

    override suspend fun markReadNotification(
        request: _MarkReadNotificationRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return notificationFeedReceiver.markReadNotification(request)
    }

    override suspend fun getUnreadNotificationCount(): NetworkResponse<APIResponse<_GetUnreadNotificationCountResponse_>> {
        return notificationFeedReceiver.getUnreadNotificationCount()
    }
}