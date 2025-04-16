package com.likeminds.likemindsfeed.feed.model

class GetFeedRequest private constructor(
    val page: Int,
    val pageSize: Int,
    val topicIds: List<String>?,
    val startFeedWithPostIds: List<String>?
) {
    class Builder {

        private var page: Int = 1
        private var pageSize: Int = 10
        private var topicIds: List<String>? = null
        private var startFeedWithPostIds: List<String>? = null

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }
        fun startFeedWithPostIds(startFeedWithPostIds: List<String>?) =
            apply { this.startFeedWithPostIds = startFeedWithPostIds }

        fun build() = GetFeedRequest(page, pageSize, topicIds, startFeedWithPostIds)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .topicIds(topicIds)
            .startFeedWithPostIds(startFeedWithPostIds)
    }
}