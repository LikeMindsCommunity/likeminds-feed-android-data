package com.likeminds.likemindsfeed.comment.model

class LikeCommentRequest private constructor(
    val postId: String,
    val commentId: String
) {
    class Builder {
        private var postId: String = ""
        private var commentId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }

        fun build() = LikeCommentRequest(
            postId,
            commentId
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
    }
}