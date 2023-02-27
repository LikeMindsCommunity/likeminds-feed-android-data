package com.likeminds.likemindsfeed.comment.model

class AddCommentRequest private constructor(
    var postId: String,
    var text: String
) {

    class Builder {
        private var postId: String = ""
        private var text: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun text(text: String) = apply { this.text = text }

        fun build() = AddCommentRequest(postId, text)
    }

    fun toBuilder(): Builder {
        return Builder().text(text).postId(postId)
    }
}