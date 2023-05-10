package com.likeminds.likemindsfeed.post.model

class AddPostRequest private constructor(
    val text: String?,
    val attachments: List<Attachment>?
) {
    class Builder {
        private var text: String? = null
        private var attachments: List<Attachment>? = null

        fun text(text: String?) = apply { this.text = text }
        fun attachments(attachments: List<Attachment>?) =
            apply { this.attachments = attachments }

        fun build() = AddPostRequest(text, attachments)
    }

    fun toBuilder(): Builder {
        return Builder().text(text).attachments(attachments)
    }
}