package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName

class _GetPollVotesRequest_ private constructor(
    @SerializedName("poll_id")
    val pollId: String,
    @SerializedName("votes")
    val votes: List<String>
) {
    class Builder {
        private var pollId: String = ""
        private var votes: List<String> = emptyList()

        fun pollId(pollId: String) = apply { this.pollId = pollId }
        fun votes(votes: List<String>) = apply { this.votes = votes }

        fun build() = _GetPollVotesRequest_(pollId, votes)
    }

    fun toBuilder(): Builder {
        return Builder().pollId(pollId)
            .votes(votes)
    }
}