package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _AddPostRequest_ private constructor(
    @SerializedName("text")
    val text: String?,
    // todo: check
    @SerializedName("on_behalf_of_uuid")
    val onBehalfOfUUID: String?,
    @SerializedName("heading")
    val heading: String?,
    @SerializedName("attachments")
    val attachments: List<_Attachment_>?
) {
    class Builder {
        private var text: String? = null
        private var onBehalfOfUUID: String? = null
        private var heading: String? = null
        private var attachments: List<_Attachment_>? = null

        fun text(text: String?) = apply { this.text = text }
        fun onBehalfOfUUID(onBehalfOfUUID: String?) = apply { this.onBehalfOfUUID = onBehalfOfUUID }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }

        fun build() = _AddPostRequest_(
            text,
            onBehalfOfUUID,
            heading,
            attachments
        )
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
            .onBehalfOfUUID(onBehalfOfUUID)
            .heading(heading)
            .attachments(attachments)
    }
}