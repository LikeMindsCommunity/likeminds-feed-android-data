package com.likeminds.likemindsfeed.comment.model

class GetCommentLikesRequest private constructor(
    var postId: String,
    var commentId: String,
    var page: Int,
    var pageSize: Int
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

        fun build() = GetCommentLikesRequest(
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