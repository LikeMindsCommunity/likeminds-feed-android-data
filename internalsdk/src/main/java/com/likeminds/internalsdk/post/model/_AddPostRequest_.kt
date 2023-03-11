package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _AddPostRequest_ private constructor(
    @SerializedName("text")
    var text: String?,
    @SerializedName("attachments")
    var attachments: List<_Attachment_>?
) {

    class Builder {
        private var text: String? = null
        private var attachments: List<_Attachment_>? = null

        fun text(text: String?) = apply { this.text = text }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }

        fun build() = _AddPostRequest_(text, attachments)
    }

    fun toBuilder(): Builder {
        return Builder().text(text).attachments(attachments)
    }
}