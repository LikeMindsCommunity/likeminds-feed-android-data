package com.likeminds.likemindsfeed.comment.model

class ReplyCommentRequest private constructor(
    val postId: String,
    val commentId: String,
    val text: String
) {
    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var text: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun text(text: String) = apply { this.text = text }

        fun build() = ReplyCommentRequest(
            postId,
            commentId,
            text
        )
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
            .postId(postId)
            .commentId(commentId)
    }
}