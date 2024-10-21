package com.likeminds.internalsdk.search.model

import com.google.gson.annotations.SerializedName

class _SearchPostsRequest_ private constructor(
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("search")
    val search: String,
    @SerializedName("search_type")
    val searchType: String
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var search: String = ""
        private var searchType: String = ""

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String) = apply { this.search = search }
        fun searchType(searchType: String) = apply { this.searchType = searchType }
        fun build() = _SearchPostsRequest_(page, pageSize, search, searchType)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
            .pageSize(pageSize)
            .search(search)
            .searchType(searchType)
    }
}