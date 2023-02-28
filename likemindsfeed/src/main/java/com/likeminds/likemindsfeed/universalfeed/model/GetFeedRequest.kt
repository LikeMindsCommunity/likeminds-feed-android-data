package com.likeminds.likemindsfeed.universalfeed.model

class GetFeedRequest private constructor(
    var page: Int?,
    var pageSize: Int?
) {

    class Builder {

        private var page: Int? = null
        private var pageSize: Int? = null

        fun page(page: Int?) = apply { this.page = page }
        fun pageSize(pageSize: Int?) = apply { this.pageSize = pageSize }

        fun build() = GetFeedRequest(page, pageSize)
    }

    fun toBuilder(): Builder {
        return Builder().page(page).pageSize(pageSize)
    }
}