package com.likeminds.internalsdk.topic.model

import com.google.gson.annotations.SerializedName

class _GetTopicsRequest_ private constructor(
    @SerializedName("is_enabled")
    val isEnabled: Boolean?,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("search")
    val search: String?,
    @SerializedName("search_type")
    val searchType: String?
) {
    class Builder {
        private var isEnabled: Boolean? = null
        private var page: Int = 1
        private var pageSize: Int = 10
        private var search: String? = null
        private var searchType: String? = null

        fun isEnabled(isEnabled: Boolean?) = apply { this.isEnabled = isEnabled }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun search(search: String?) = apply { this.search = search }
        fun searchType(searchType: String?) = apply { this.searchType = searchType }

        fun build() = _GetTopicsRequest_(isEnabled, page, pageSize, search, searchType)
    }

    fun toBuilder(): Builder {
        return Builder().isEnabled(isEnabled)
            .page(page)
            .pageSize(pageSize)
            .search(search)
            .searchType(searchType)
    }
}