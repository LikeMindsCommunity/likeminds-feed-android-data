package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _DeleteCommentRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("comment_id")
    val commentId: String?,
    @SerializedName("reason")
    val reason: String?
) {
    class Builder {
        private var postId: String? = null
        private var commentId: String? = null
        private var reason: String? = null

        fun postId(postId: String?) = apply { this.postId = postId }
        fun commentId(commentId: String?) = apply { this.commentId = commentId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = _DeleteCommentRequest_(
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