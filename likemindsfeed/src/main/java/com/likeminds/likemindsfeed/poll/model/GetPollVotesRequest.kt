package com.likeminds.likemindsfeed.poll.model

class GetPollVotesRequest private constructor(
    val pollId: String,
    val votes: List<String>,
    val page: Int,
    val pageSize: Int
) {
    class Builder {
        private var pollId: String = ""
        private var votes: List<String> = emptyList()
        private var page: Int = 1
        private var pageSize: Int = 10

        fun pollId(pollId: String) = apply {
            this.pollId = pollId
        }

        fun votes(votes: List<String>) = apply {
            this.votes = votes
        }

        fun page(page: Int) = apply {
            this.page = page
        }

        fun pageSize(pageSize: Int) = apply {
            this.pageSize = pageSize
        }

        fun build() = GetPollVotesRequest(
            pollId,
            votes,
            page,
            pageSize
        )
    }

    override fun toString(): String {
        return "GetPollVotesRequest(pollId: $pollId, votes:$votes)"
    }

    fun toBuilder(): Builder {
        return Builder().pollId(pollId)
            .votes(votes)
            .page(page)
            .pageSize(pageSize)
    }
}