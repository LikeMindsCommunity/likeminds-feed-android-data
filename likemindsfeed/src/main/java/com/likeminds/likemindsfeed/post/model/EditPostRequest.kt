package com.likeminds.likemindsfeed.post.model

class EditPostRequest private constructor(
    val postId: String,
    val text: String?,
    val heading: String?,
    val attachments: List<Attachment>?
) {
    class Builder {
        private var postId: String = ""
        private var text: String? = null
        private var heading: String? = null
        private var attachments: List<Attachment>? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun text(text: String?) = apply { this.text = text }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }

        fun build() = EditPostRequest(
            postId,
            text,
            heading,
            attachments
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
            .heading(heading)
            .attachments(attachments)
    }
}