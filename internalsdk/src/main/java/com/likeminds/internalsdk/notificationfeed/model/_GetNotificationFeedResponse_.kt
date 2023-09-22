package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.widgets.model._Widget_

data class _GetNotificationFeedResponse_(
    @SerializedName("activities")
    val activities: List<_Activity_>,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widget_>
)