package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName

class _GetFeedRequest_ private constructor(
    @SerializedName("page")
    var page: Int,
    @SerializedName("page_size")
    var pageSize: Int
) {
    class Builder {
        private var page: Int = 1
        private var pageSize: Int = 10

        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = _GetFeedRequest_(page, pageSize)
    }

    fun toBuilder(): Builder {
        return Builder().page(page).pageSize(pageSize)
    }
}