package com.likeminds.likemindsfeed.poll.model

class GetPollVotesRequest private constructor(
    val pollId: String,
    val votes: List<String>
) {
    class Builder {
        private var pollId: String = ""
        private var votes: List<String> = emptyList()

        fun pollId(pollId: String) = apply { this.pollId = pollId }
        fun votes(votes: List<String>) = apply { this.votes = votes }

        fun build() = GetPollVotesRequest(pollId, votes)
    }

    override fun toString(): String {
        return "GetPollVotesRequest(pollId: $pollId, votes:$votes)"
    }

    fun toBuilder(): Builder {
        return Builder().pollId(pollId)
            .votes(votes)
    }
}