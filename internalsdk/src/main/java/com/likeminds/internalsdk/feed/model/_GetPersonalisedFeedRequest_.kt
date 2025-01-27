package com.likeminds.internalsdk.feed.model

import com.google.gson.annotations.SerializedName

class _GetPersonalisedFeedRequest_ private constructor(
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("should_recompute")
    val shouldRecompute: Boolean?,
    @SerializedName("should_reorder")
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

        fun build() = _GetPersonalisedFeedRequest_(page, pageSize, shouldRecompute, shouldReorder)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .shouldRecompute(shouldRecompute)
            .shouldReorder(shouldReorder)
    }
}