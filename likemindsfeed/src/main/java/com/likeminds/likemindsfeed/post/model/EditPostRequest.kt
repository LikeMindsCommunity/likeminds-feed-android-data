package com.likeminds.likemindsfeed.post.model

class EditPostRequest private constructor(
    var postId: String?,
    var text: String?,
    var attachments: List<Attachment>?
) {

    class Builder {
        private var postId: String? = null
        private var text: String? = null
        private var attachments: List<Attachment>? = null

        fun postId(postId: String?) = apply { this.postId = postId }
        fun text(text: String?) = apply { this.text = text }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }

        fun build() = EditPostRequest(
            postId,
            text,
            attachments
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
            .attachments(attachments)
    }
}