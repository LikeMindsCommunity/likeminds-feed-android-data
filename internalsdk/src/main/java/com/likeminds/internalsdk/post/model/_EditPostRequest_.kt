package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _EditPostRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String?,
    @SerializedName("text")
    var text: String?,
    @SerializedName("attachments")
    var attachments: List<_Attachment_>?
) {

    class Builder {
        private var postId: String? = null
        private var text: String? = null
        private var attachments: List<_Attachment_>? = null

        fun postId(postId: String?) = apply { this.postId = postId }
        fun text(text: String?) = apply { this.text = text }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }

        fun build() = _EditPostRequest_(
            postId,
            text,
            attachments
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
            .attachments(attachments)
    }
}