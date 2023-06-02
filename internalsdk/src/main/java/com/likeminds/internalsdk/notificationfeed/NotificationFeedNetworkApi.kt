package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.notificationfeed.model._GetUnreadNotificationCountResponse_
import com.likeminds.internalsdk.utils.retrofit.model.APIResponse
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NotificationFeedNetworkApi {

    @GET("feed/user/activity")
    suspend fun getNotificationFeed(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): NetworkResponse<APIResponse<_GetNotificationFeedResponse_>>

    @GET("feed/user/activity/{activity_id}/mark_read")
    suspend fun markReadNotification(
        @Path("activity_id") activityId: String
    ): NetworkResponse<APIResponse<Nothing>>

    @GET("feed/user/activity/unread_count")
    suspend fun getUnreadNotificationCount(): NetworkResponse<APIResponse<_GetUnreadNotificationCountResponse_>>
}