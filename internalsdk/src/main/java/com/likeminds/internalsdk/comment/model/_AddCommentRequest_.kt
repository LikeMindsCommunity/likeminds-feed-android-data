package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _AddCommentRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String?,
    @SerializedName("text")
    var text: String
) {

    class Builder {
        private var postId: String? = null
        private var text: String = ""

        fun text(text: String) = apply { this.text = text }
        fun postId(postId: String?) = apply { this.postId = postId }

        fun build() = _AddCommentRequest_(
            postId,
            text
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
    }
}