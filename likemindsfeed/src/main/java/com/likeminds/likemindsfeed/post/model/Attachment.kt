package com.likeminds.likemindsfeed.post.model

import org.json.JSONObject

class Attachment private constructor(
    val attachmentType: AttachmentType,
    val attachmentMeta: JSONObject
) {
    class Builder {

        private var attachmentType: AttachmentType = AttachmentType.NONE
        private var attachmentMeta: JSONObject = JSONObject()

        fun attachmentType(attachmentType: AttachmentType) =
            apply { this.attachmentType = attachmentType }

        fun attachmentMeta(attachmentMeta: JSONObject) =
            apply { this.attachmentMeta = attachmentMeta }

        fun build() = Attachment(attachmentType, attachmentMeta)
    }

    fun toBuilder(): Builder {
        return Builder().attachmentType(attachmentType).attachmentMeta(attachmentMeta)
    }
}