package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class Attachment(
    @SerializedName("attachment_type")
    var attachmentType: Int,
    @SerializedName("attachment_meta")
    var attachmentMeta: AttachmentMeta?
)