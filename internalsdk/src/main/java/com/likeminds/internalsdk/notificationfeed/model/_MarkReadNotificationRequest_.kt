package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName

class _MarkReadNotificationRequest_ private constructor(
    @SerializedName("activity_id")
    val activityId: String
) {
    class Builder {
        private var activityId: String = ""

        fun activityId(activityId: String) = apply { this.activityId = activityId }

        fun build() = _MarkReadNotificationRequest_(activityId)
    }

    fun toBuilder(): Builder {
        return Builder().activityId(activityId)
    }
}