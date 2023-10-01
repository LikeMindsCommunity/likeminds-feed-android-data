package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName

class _GetFeedRequest_ private constructor(
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("topic_ids")
    val topicIds: List<String>?
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var topicIds: List<String>? = null

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }
        fun build() = _GetFeedRequest_(page, pageSize, topicIds)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .topicIds(topicIds)
    }
}