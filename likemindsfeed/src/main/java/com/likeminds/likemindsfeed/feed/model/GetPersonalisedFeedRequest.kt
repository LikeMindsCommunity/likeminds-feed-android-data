package com.likeminds.likemindsfeed.feed.model

class GetPersonalisedFeedRequest private constructor(
    val page: Int,
    val pageSize: Int,
    val shouldRecompute: Boolean?,
    val shouldReorder: Boolean?
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var shouldRecompute: Boolean? = null
        private var shouldReorder: Boolean? = null

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

        fun build() = GetPersonalisedFeedRequest(page, pageSize, shouldRecompute, shouldReorder)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .shouldReorder(shouldReorder)
            .shouldRecompute(shouldRecompute)
    }
}