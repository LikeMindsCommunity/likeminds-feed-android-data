package com.likeminds.likemindsfeed.post.model

class AddPostRequest private constructor(
    var text: String?,
    var attachments: List<Attachment>?
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