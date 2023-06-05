package com.likeminds.likemindsfeed.notificationfeed

import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class NotificationFeedClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().notificationFeedComponent()?.inject(this)
    }

    private val notificationFeedApi by lazy {
        collabmatesSDK.getNotificationFeedApi()
    }
}