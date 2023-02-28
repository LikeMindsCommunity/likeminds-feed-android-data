package com.likeminds.internalsdk.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedResponse_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NotificationFeedNetworkApi {

    @GET("feed/notification")
    suspend fun getNotificationFeed(
        @Query("page") page: Int?,
        @Query("page_size") pageSize: Int?
    ): NetworkResponse<_GetNotificationFeedResponse_>
}