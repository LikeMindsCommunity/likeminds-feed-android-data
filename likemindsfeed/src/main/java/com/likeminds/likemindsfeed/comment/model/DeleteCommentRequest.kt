package com.likeminds.likemindsfeed.comment.model

class DeleteCommentRequest private constructor(
    var postId: String,
    var commentId: String,
    var reason: String?
) {

    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var reason: String? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = DeleteCommentRequest(
            postId,
            commentId,
            reason
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
            .reason(reason)
    }
}