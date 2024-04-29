package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName

class _AddPollOptionRequest_ private constructor(
    @SerializedName("text")
    val text: String
) {
    class Builder {
        private var text: String = ""

        fun text(text: String) = apply { this.text = text }

        fun build() = _AddPollOptionRequest_(text)
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
    }
}