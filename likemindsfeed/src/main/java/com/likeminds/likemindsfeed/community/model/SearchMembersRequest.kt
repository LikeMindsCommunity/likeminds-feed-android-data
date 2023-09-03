package com.likeminds.likemindsfeed.community.model

class SearchMembersRequest private constructor(
    val page: Int,
    val pageSize: Int,
    val search: String,
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 1
        private var search: String = ""

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String) = apply { this.search = search }

        fun build() = SearchMembersRequest(
            page,
            pageSize,
            search
        )
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .search(search)
    }
}