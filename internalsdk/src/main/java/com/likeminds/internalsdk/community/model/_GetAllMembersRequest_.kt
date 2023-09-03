package com.likeminds.internalsdk.community.model

class _GetAllMembersRequest_ private constructor(
    val page: Int
) {
    class Builder {
        private var page: Int = 1

        fun page(page: Int) = apply { this.page = page }

        fun build() = _GetAllMembersRequest_(page)
    }

    fun toBuilder(): Builder {
        return Builder().page(page)
    }
}