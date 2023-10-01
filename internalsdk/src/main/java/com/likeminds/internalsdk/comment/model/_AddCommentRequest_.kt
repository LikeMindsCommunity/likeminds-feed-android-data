package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _AddCommentRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("text")
    val text: String,
    @SerializedName("temp_id")
    val tempId: String?
) {
    class Builder {
        private var postId: String? = null
        private var text: String = ""
        private var tempId: String? = null

        fun text(text: String) = apply { this.text = text }
        fun postId(postId: String?) = apply { this.postId = postId }
        fun tempId(tempId: String?) = apply { this.tempId = tempId }

        fun build() = _AddCommentRequest_(
            postId,
            text,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
            .tempId(tempId)
    }
}