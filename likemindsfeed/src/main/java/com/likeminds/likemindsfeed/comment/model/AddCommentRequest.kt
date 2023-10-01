package com.likeminds.likemindsfeed.comment.model

class AddCommentRequest private constructor(
    val postId: String,
    val text: String,
    val tempId: String?
) {
    class Builder {
        private var postId: String = ""
        private var text: String = ""
        private var tempId: String? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun text(text: String) = apply { this.text = text }
        fun tempId(tempId: String?) = apply { this.tempId = tempId }

        fun build() = AddCommentRequest(
            postId,
            text,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
            .postId(postId)
            .tempId(tempId)
    }
}