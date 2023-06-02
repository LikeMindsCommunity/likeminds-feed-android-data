package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.notificationfeed.model._GetUnreadNotificationCountResponse_
import com.likeminds.internalsdk.notificationfeed.model._MarkReadNotificationRequest_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import javax.inject.Inject

class NotificationFeedReceiver @Inject constructor(
    private val notificationFeedNetworkApi: NotificationFeedNetworkApi
) {

    suspend fun getNotificationFeed(
        request: _GetNotificationFeedRequest_
    ): NetworkResponse<APIResponse<_GetNotificationFeedResponse_>> {
        return notificationFeedNetworkApi.getNotificationFeed(
            request.page,
            request.pageSize
        )
    }

    suspend fun markReadNotification(
        request: _MarkReadNotificationRequest_
    ): NetworkResponse<APIResponse<Nothing>> {
        return notificationFeedNetworkApi.markReadNotification(request.activityId)
    }

    suspend fun getUnreadNotificationCount(): NetworkResponse<APIResponse<_GetUnreadNotificationCountResponse_>> {
        return notificationFeedNetworkApi.getUnreadNotificationCount()
    }
}