package com.likeminds.likemindsfeed.post.model

import com.likeminds.internalsdk.post.model.Attachment

class AddPostRequest private constructor(
    var text: String?,
    var attachments: MutableList<Attachment>?
) {

    class Builder {
        private var text: String? = null
        private var attachments: MutableList<Attachment>? = null

        fun text(text: String?) = apply { this.text = text }
        fun attachments(attachments: MutableList<Attachment>?) =
            apply { this.attachments = attachments }

        fun build() = AddPostRequest(text, attachments)
    }

    fun toBuilder(): Builder {
        return Builder().text(text).attachments(attachments)
    }
}