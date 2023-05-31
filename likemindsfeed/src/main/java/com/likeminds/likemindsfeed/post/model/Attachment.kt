package com.likeminds.likemindsfeed.post.model

class Attachment private constructor(
    val attachmentType: Int,
    val attachmentMeta: AttachmentMeta
) {
    class Builder {

        private var attachmentType: Int = 1
        private var attachmentMeta: AttachmentMeta = AttachmentMeta.Builder().build()

        fun attachmentType(attachmentType: Int) = apply { this.attachmentType = attachmentType }
        fun attachmentMeta(attachmentMeta: AttachmentMeta) =
            apply { this.attachmentMeta = attachmentMeta }

        fun build() = Attachment(attachmentType, attachmentMeta)
    }

    fun toBuilder(): Builder {
        return Builder().attachmentType(attachmentType).attachmentMeta(attachmentMeta)
    }
}