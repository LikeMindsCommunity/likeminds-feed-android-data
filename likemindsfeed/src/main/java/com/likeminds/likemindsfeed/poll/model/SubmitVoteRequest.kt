package com.likeminds.likemindsfeed.poll.model

class SubmitVoteRequest private constructor(
    val pollId: String,
    val votes: List<String>
) {
    class Builder {
        private var pollId: String = ""
        private var votes: List<String> = emptyList()

        fun pollId(pollId: String) = apply { this.pollId = pollId }
        fun votes(votes: List<String>) = apply { this.votes = votes }

        fun build() = SubmitVoteRequest(
            pollId,
            votes
        )
    }

    override fun toString(): String {
        return "SubmitVoteRequest(pollId: $pollId, votes:$votes)"
    }

    fun toBuilder(): Builder {
        return Builder().votes(votes)
            .pollId(pollId)
    }
}