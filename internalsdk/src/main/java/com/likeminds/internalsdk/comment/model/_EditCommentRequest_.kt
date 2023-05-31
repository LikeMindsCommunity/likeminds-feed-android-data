package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _EditCommentRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("comment_id")
    val commentId: String?,
    @SerializedName("text")
    val text: String
) {
    class Builder {
        private var postId: String? = null
        private var commentId: String? = null
        private var text: String = ""

        fun postId(postId: String?) = apply { this.postId = postId }
        fun commentId(commentId: String?) = apply { this.commentId = commentId }
        fun text(text: String) = apply { this.text = text }

        fun build() = _EditCommentRequest_(
            postId,
            commentId,
            text
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .commentId(commentId)
            .text(text)
    }
}