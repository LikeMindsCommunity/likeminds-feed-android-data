package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName

class _GetNotificationFeedRequest_ private constructor(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("page_size")
    var pageSize: Int?
) {

    class Builder {
        private var page: Int? = null
        private var pageSize: Int? = null

        fun page(page: Int?) = apply { this.page = page }
        fun pageSize(pageSize: Int?) = apply { this.pageSize = pageSize }

        fun build() = _GetNotificationFeedRequest_(page, pageSize)
    }

    fun toBuilder(): Builder {
        return Builder().page(page).pageSize(pageSize)
    }
}