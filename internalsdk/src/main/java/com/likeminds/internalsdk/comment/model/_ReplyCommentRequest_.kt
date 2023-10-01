package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _ReplyCommentRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("comment_id")
    val commentId: String?,
    @SerializedName("text")
    val text: String,
    @SerializedName("temp_id")
    val tempId: String?
) {
    class Builder {
        private var postId: String? = null
        private var commentId: String? = null
        private var text: String = ""
        private var tempId: String? = null

        fun text(text: String) = apply { this.text = text }
        fun postId(postId: String?) = apply { this.postId = postId }
        fun commentId(commentId: String?) = apply { this.commentId = commentId }
        fun tempId(tempId: String?) = apply { this.tempId = tempId }

        fun build() = _ReplyCommentRequest_(
            postId,
            commentId,
            text,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .commentId(commentId)
            .text(text)
            .tempId(tempId)
    }
}