package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _Attachment_ private constructor(
    @SerializedName("attachment_type")
    val attachmentType: Int,
    @SerializedName("attachment_meta")
    val attachmentMeta: _AttachmentMeta_
) {
    class Builder {

        private var attachmentType: Int = 1
        private var attachmentMeta: _AttachmentMeta_ = _AttachmentMeta_.Builder().build()

        fun attachmentType(attachmentType: Int) = apply { this.attachmentType = attachmentType }
        fun attachmentMeta(attachmentMeta: _AttachmentMeta_) =
            apply { this.attachmentMeta = attachmentMeta }

        fun build() = _Attachment_(attachmentType, attachmentMeta)
    }

    fun toBuilder(): Builder {
        return Builder().attachmentType(attachmentType).attachmentMeta(attachmentMeta)
    }
}