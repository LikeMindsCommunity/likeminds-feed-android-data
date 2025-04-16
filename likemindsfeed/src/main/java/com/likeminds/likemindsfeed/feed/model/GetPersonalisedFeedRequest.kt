package com.likeminds.likemindsfeed.feed.model

class GetPersonalisedFeedRequest private constructor(
    val page: Int,
    val pageSize: Int,
    val shouldRecompute: Boolean?,
    val shouldReorder: Boolean?,
    val startFeedWithPostIds: List<String>?
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var shouldRecompute: Boolean? = null
        private var shouldReorder: Boolean? = null
        private var startFeedWithPostIds: List<String>? = null

        fun page(page: Int) = apply {
            this.page = page
        }

        fun pageSize(pageSize: Int) = apply {
            this.pageSize = pageSize
        }

        fun shouldRecompute(shouldRecompute: Boolean?) = apply {
            this.shouldRecompute = shouldRecompute
        }

        fun shouldReorder(shouldReorder: Boolean?) = apply {
            this.shouldReorder = shouldReorder
        }

        fun startFeedWithPostIds(postIds: List<String>?) = apply {
            this.startFeedWithPostIds = postIds
        }

        fun build() = GetPersonalisedFeedRequest(
            page,
            pageSize,
            shouldRecompute,
            shouldReorder,
            startFeedWithPostIds
        )
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .shouldReorder(shouldReorder)
            .shouldRecompute(shouldRecompute)
            .startFeedWithPostIds(startFeedWithPostIds)
    }
}