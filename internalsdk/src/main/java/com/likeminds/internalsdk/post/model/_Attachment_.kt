package com.likeminds.internalsdk.post.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class _Attachment_ private constructor(
    @SerializedName("attachment_type")
    val attachmentType: Int,
    @SerializedName("attachment_meta")
    val attachmentMeta: JsonObject
) {
    class Builder {

        private var attachmentType: Int = 1
        private var attachmentMeta: JsonObject = JsonObject()

        fun attachmentType(attachmentType: Int) = apply { this.attachmentType = attachmentType }
        fun attachmentMeta(attachmentMeta: JsonObject) =
            apply { this.attachmentMeta = attachmentMeta }

        fun build() = _Attachment_(attachmentType, attachmentMeta)
    }

    fun toBuilder(): Builder {
        return Builder().attachmentType(attachmentType).attachmentMeta(attachmentMeta)
    }
}