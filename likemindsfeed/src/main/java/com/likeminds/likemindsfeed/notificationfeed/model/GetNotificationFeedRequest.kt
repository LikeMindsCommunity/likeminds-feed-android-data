package com.likeminds.likemindsfeed.notificationfeed.model

class GetNotificationFeedRequest private constructor(
    val page: Int,
    val pageSize: Int
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = GetNotificationFeedRequest(page, pageSize)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
    }
}