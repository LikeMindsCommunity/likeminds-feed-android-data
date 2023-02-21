package com.likeminds.internalsdk.post.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class _Attachment_(
    @SerializedName("attachment_type")
    var attachmentType: Int,
    @SerializedName("attachment_meta")
    var attachmentMeta: _AttachmentMeta_
)