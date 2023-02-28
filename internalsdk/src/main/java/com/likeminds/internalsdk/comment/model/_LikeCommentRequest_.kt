package com.likeminds.internalsdk.comment.model

class _LikeCommentRequest_ private constructor(
    var postId: String,
    var commentId: String
) {

    class Builder {
        private var postId: String = ""
        private var commentId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }

        fun build() = _LikeCommentRequest_(
            postId,
            commentId
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
    }
}