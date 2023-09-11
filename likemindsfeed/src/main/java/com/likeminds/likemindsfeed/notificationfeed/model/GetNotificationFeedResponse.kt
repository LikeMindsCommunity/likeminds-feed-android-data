package com.likeminds.likemindsfeed.notificationfeed.model

import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.widgets.model.Widgets

data class GetNotificationFeedResponse(
    val activities: List<Activity>,
    val users: Map<String, User>,
    val widgets: Map<String, Widgets>
)