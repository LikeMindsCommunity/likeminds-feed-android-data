package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName

class _AddPollOptionRequest_ private constructor(
    @SerializedName("text")
    val text: String,
    @SerializedName("poll_id")
    val pollId: String?
) {
    class Builder {
        private var text: String = ""
        private var pollId: String? = null

        fun text(text: String) = apply { this.text = text }
        fun pollId(pollId: String?) = apply { this.pollId = pollId }

        fun build() = _AddPollOptionRequest_(text, pollId)
    }

    fun toBuilder(): Builder {
        return Builder().text(text).pollId(pollId)
    }
}