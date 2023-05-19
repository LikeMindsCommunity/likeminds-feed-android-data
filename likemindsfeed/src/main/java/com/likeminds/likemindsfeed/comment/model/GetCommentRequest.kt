package com.likeminds.likemindsfeed.comment.model

class GetCommentRequest private constructor(
    val postId: String,
    val commentId: String,
    val page: Int,
    val pageSize: Int
) {
    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var page: Int = 1
        private var pageSize: Int = 10

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = GetCommentRequest(
            postId,
            commentId,
            page,
            pageSize
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
            .page(page)
            .pageSize(pageSize)
    }
}