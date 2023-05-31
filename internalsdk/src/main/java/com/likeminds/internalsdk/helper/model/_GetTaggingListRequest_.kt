package com.likeminds.internalsdk.helper.model

import com.google.gson.annotations.SerializedName

class _GetTaggingListRequest_ private constructor(
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("search_name")
    val searchName: String?
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10
        private var searchName: String? = null

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }
        fun searchName(searchName: String?) = apply { this.searchName = searchName }

        fun build() = _GetTaggingListRequest_(
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