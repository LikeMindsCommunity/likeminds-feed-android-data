package com.likeminds.likemindsfeed.community.model

class GetAllMembersRequest private constructor(
    val page: Int
) {
    class Builder {
        private var page: Int = 1

        fun page(page: Int) = apply { this.page = page }

        fun build() = GetAllMembersRequest(page)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
    }
}