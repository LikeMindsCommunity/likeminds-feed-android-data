package com.likeminds.likemindsfeed.poll.model

class AddPollOptionRequest private constructor(
    val pollId: String,
    val text: String
) {

    class Builder {
        private var pollId: String = ""
        private var text: String = ""

        fun pollId(pollId: String) = apply { this.pollId = pollId }
        fun text(text: String) = apply { this.text = text }

        fun build() = AddPollOptionRequest(
            pollId,
            text
        )
    }

    override fun toString(): String {
        return "AddPollOptionRequest(pollId: $pollId, text: $text)"
    }

    fun toBuilder(): Builder {
        return Builder().pollId(pollId)
            .text(text)
    }
}