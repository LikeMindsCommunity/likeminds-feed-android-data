package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.notificationfeed.model._GetUnreadNotificationCountResponse_
import com.likeminds.internalsdk.notificationfeed.model._MarkReadNotificationRequest_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse

interface NotificationFeedApi {

    // api to fetch notification feed
    suspend fun getNotificationFeed(
        request: _GetNotificationFeedRequest_
    ): NetworkResponse<APIResponse<_GetNotificationFeedResponse_>>

    // api to mark a notification as read
    suspend fun markReadNotification(
        request: _MarkReadNotificationRequest_
    ): NetworkResponse<APIResponse<Nothing>>

    // api to get count of unread notifications
    suspend fun getUnreadNotificationCount(): NetworkResponse<APIResponse<_GetUnreadNotificationCountResponse_>>
}