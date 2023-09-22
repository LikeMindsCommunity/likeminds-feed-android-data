package com.likeminds.likemindsfeed.comment.model

class ReplyCommentRequest private constructor(
    val postId: String,
    val commentId: String,
    val text: String,
    val tempId: String?
) {
    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var text: String = ""
        private var tempId: String? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun text(text: String) = apply { this.text = text }
        fun tempId(tempId: String?) = apply { this.tempId = tempId }

        fun build() = ReplyCommentRequest(
            postId,
            commentId,
            text,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
            .postId(postId)
            .commentId(commentId)
            .tempId(tempId)
    }
}