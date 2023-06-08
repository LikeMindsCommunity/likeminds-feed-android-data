package com.likeminds.likemindsfeed.notificationfeed.model

class MarkReadNotificationRequest private constructor(
    val activityId: String
) {
    class Builder {
        private var activityId: String = ""

        fun activityId(activityId: String) = apply { this.activityId = activityId }

        fun build() = MarkReadNotificationRequest(activityId)
    }

    fun toBuilder(): Builder {
        return Builder().activityId(activityId)
    }
}