package com.likeminds.likemindsfeed.topic.model

class GetTopicRequest private constructor(
    val isEnabled: Boolean?,
    val page: Int,
    val pageSize: Int,
    val search: String?,
    val searchType: String?
) {

    class Builder {
        private var isEnabled: Boolean? = null
        private var page: Int = 0
        private var pageSize: Int = 0
        private var search: String? = null
        private var searchType: String? = null

        fun isEnabled(isEnabled: Boolean?) = apply { this.isEnabled = isEnabled }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String?) = apply { this.search = search }
        fun searchType(searchType: String?) = apply { this.searchType = searchType }

        fun build() = GetTopicRequest(isEnabled, page, pageSize, search, searchType)
    }

    fun toBuilder(): Builder {
        return Builder().isEnabled(isEnabled)
            .page(page)
            .pageSize(pageSize)
            .search(search)
            .searchType(searchType)
    }
}