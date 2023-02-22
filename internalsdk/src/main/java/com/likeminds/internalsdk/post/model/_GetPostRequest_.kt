package com.likeminds.internalsdk.post.model

class _GetPostRequest_ private constructor(
    var postId: String,
    var page: Int?,
    var pageSize: Int?
) {

    class Builder {
        private var postId: String = ""
        private var page: Int? = null
        private var pageSize: Int? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun page(page: Int?) = apply { this.page = page }
        fun pageSize(pageSize: Int?) = apply { this.pageSize = pageSize }

        fun build() = _GetPostRequest_(
            postId,
            page,
            pageSize
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .page(page)
            .pageSize(pageSize)
    }
}