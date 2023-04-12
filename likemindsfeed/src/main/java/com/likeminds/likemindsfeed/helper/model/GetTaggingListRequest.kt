package com.likeminds.likemindsfeed.helper.model

class GetTaggingListRequest private constructor(
    var page: Int,
    var pageSize: Int,
    var searchName: String?
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var searchName: String? = null

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun searchName(searchName: String?) = apply { this.searchName = searchName }

        fun build() = GetTaggingListRequest(
            page,
            pageSize,
            searchName
        )
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .searchName(searchName)
    }
}