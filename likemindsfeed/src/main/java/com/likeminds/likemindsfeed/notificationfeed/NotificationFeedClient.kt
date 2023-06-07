package com.likeminds.likemindsfeed.notificationfeed

import com.likeminds.internalsdk.notificationfeed.model._GetNotificationFeedRequest_
import com.likeminds.internalsdk.notificationfeed.model._MarkReadNotificationRequest_
import com.likeminds.internalsdk.utils.retrofit.model.NetworkResponse
import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedRequest
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedResponse
import com.likeminds.likemindsfeed.notificationfeed.model.GetUnreadNotificationCountResponse
import com.likeminds.likemindsfeed.notificationfeed.model.MarkReadNotificationRequest
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.sdk.ModelConverter
import com.likeminds.likemindsfeed.util.RequestUtils
import javax.inject.Inject

class NotificationFeedClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().notificationFeedComponent()?.inject(this)
    }

    private val notificationFeedApi by lazy {
        collabmatesSDK.getNotificationFeedApi()
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param getNotificationFeedRequest - client request model to fetch notification feed
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return GetNotificationFeedResponse - GetNotificationFeedResponse model for getNotificationFeedRequest
     */
    suspend fun getNotificationFeed(getNotificationFeedRequest: GetNotificationFeedRequest): LMResponse<GetNotificationFeedResponse> {
        // validates the client request
        RequestUtils.validate()

        // builds internal request model
        val request = _GetNotificationFeedRequest_.Builder()
            .page(getNotificationFeedRequest.page)
            .pageSize(getNotificationFeedRequest.pageSize)
            .build()

        // calls api and processes the response accordingly
        return when (val response = notificationFeedApi.getNotificationFeed(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetNotificationFeedAPIResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api to get count of unread notifications
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return GetNotificationFeedResponse - GetNotificationFeedResponse model for getNotificationFeedRequest
     */
    suspend fun getUnreadNotificationCount(): LMResponse<GetUnreadNotificationCountResponse> {
        // validates the client request
        RequestUtils.validate()

        // calls api and processes the response accordingly
        return when (val response = notificationFeedApi.getUnreadNotificationCount()) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                )
            }
            is NetworkResponse.Success -> {
                ModelConverter.convertGetUnreadNotificationCountAPIResponse(response.body)
            }
        }
    }

    /**
     * Converts client request model to internal model and calls the api
     * @param markReadNotificationRequest - client request model to  mark a notification as read
     * @throws IllegalArgumentException - when LMFeedClient is not instantiated
     * @return LMResponse<Nothing> - Base LM response
     */
    suspend fun markReadNotification(markReadNotificationRequest: MarkReadNotificationRequest): LMResponse<Nothing> {
        // validates the client request
        RequestUtils.validate()
        markReadNotificationRequest(markReadNotificationRequest)

        // builds internal request model
        val request = _MarkReadNotificationRequest_.Builder()
            .activityId(markReadNotificationRequest.activityId)
            .build()

        // calls api and processes the response accordingly
        return when (val response = notificationFeedApi.markReadNotification(request)) {
            is NetworkResponse.Error -> {
                LMResponse(
                    success = response.body.success,
                    errorMessage = response.body.errorMessage,
                )
            }
            is NetworkResponse.Success -> {
                LMResponse(
                    success = response.body.success
                )
            }
        }
    }

    /**
     * validates [markReadNotificationRequest]
     * @throws IllegalArgumentException - when required properties not provided
     */
    private fun markReadNotificationRequest(markReadNotificationRequest: MarkReadNotificationRequest) {
        if (markReadNotificationRequest.activityId.isEmpty()) {
            RequestUtils.throwException("activityId")
        }
    }
}