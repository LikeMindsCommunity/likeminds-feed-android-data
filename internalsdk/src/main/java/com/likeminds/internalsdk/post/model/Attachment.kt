package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class Attachment private constructor(
    @SerializedName("attachment_type")
    var attachmentType: Int,
    @SerializedName("attachment_meta")
    var attachmentMeta: AttachmentMeta?
) {
    class Builder {

        private var attachmentType: Int = 1
        private var attachmentMeta: AttachmentMeta? = null

        fun attachmentType(attachmentType: Int) = apply { this.attachmentType = attachmentType }
        fun attachmentMeta(attachmentMeta: AttachmentMeta?) =
            apply { this.attachmentMeta = attachmentMeta }

        fun build() = Attachment(attachmentType, attachmentMeta)
    }

    fun toBuilder(): Builder {
        return Builder().attachmentType(attachmentType).attachmentMeta(attachmentMeta)
    }
}