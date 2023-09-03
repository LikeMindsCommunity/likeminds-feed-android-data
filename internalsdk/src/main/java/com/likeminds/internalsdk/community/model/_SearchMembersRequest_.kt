package com.likeminds.internalsdk.community.model

class _SearchMembersRequest_ private constructor(
    val page: Int,
    val pageSize: Int,
    val search: String,
    val searchType: String,
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 1
        private var search: String = ""
        private var searchType: String = "name"

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String) = apply { this.search = search }
        fun searchType(searchType: String) = apply { this.searchType = searchType }

        fun build() = _SearchMembersRequest_(
            page,
            pageSize,
            search,
            searchType
        )
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .search(search)
            .searchType(searchType)
    }
}