package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName

//TODO: to be added to ED and change data
data class _GetNotificationFeedResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: String?
)

//data class _NotificationFeedData_(
//
//)