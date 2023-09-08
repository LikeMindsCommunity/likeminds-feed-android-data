package com.likeminds.likemindsfeed.notificationfeed.model

import com.likeminds.likemindsfeed.post.model.Widgets
import com.likeminds.likemindsfeed.sdk.model.User

data class GetNotificationFeedResponse(
    val activities: List<Activity>,
    val users: Map<String, User>,
    val widgets: Map<String, Widgets>
)