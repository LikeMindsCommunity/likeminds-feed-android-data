package com.likeminds.likemindsfeed.comment.model

class EditCommentRequest private constructor(
    var postId: String,
    var commentId: String,
    var text: String
) {

    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var text: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun text(text: String) = apply { this.text = text }

        fun build() = EditCommentRequest(
            postId,
            commentId,
            text
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
            .text(text)
    }
}