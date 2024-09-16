package com.likeminds.likemindsfeed.search.model

class GetSearchPostsRequest private constructor(
    val page: Int,
    val pageSize: Int,
    val search: String?,
    val searchType: String?
){

    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var search: String? = null
        private var searchType: String? = null

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String?) = apply { this.search = search }
        fun searchType(searchType: String?) = apply { this.searchType = searchType }

        fun build() = GetSearchPostsRequest(page, pageSize, search, searchType)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .search(search)
            .searchType(searchType)
    }
}