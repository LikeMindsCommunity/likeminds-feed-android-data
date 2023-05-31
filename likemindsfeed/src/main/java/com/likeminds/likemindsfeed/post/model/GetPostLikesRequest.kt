package com.likeminds.likemindsfeed.post.model

class GetPostLikesRequest private constructor(
    val postId: String,
    val page: Int,
    val pageSize: Int
) {
    class Builder {
        private var postId: String = ""
        private var page: Int = 1
        private var pageSize: Int = 10

        fun postId(postId: String) = apply { this.postId = postId }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = GetPostLikesRequest(
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