package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _AddCommentRequest_ private constructor(
    @SerializedName("text")
    var text: String
) {

    class Builder {
        private var text: String = ""

        fun text(text: String) = apply { this.text = text }

        fun build() = _AddCommentRequest_(text)
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
    }
}