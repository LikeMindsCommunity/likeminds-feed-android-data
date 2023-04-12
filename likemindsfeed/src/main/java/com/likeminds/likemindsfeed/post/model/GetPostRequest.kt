package com.likeminds.likemindsfeed.post.model

class GetPostRequest private constructor(
    var postId: String,
    var page: Int,
    var pageSize: Int
) {

    class Builder {
        private var postId: String = ""
        private var page: Int = 1
        private var pageSize: Int = 10

        fun postId(postId: String) = apply { this.postId = postId }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = GetPostRequest(
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