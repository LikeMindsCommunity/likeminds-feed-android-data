package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName

class _GetPollVotesRequest_ private constructor(
    @SerializedName("poll_id")
    val pollId: String,
    @SerializedName("votes")
    val votes: List<String>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
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

        fun build() = _GetPollVotesRequest_(
            pollId,
            votes,
            page,
            pageSize
        )
    }

    fun toBuilder(): Builder {
        return Builder().pollId(pollId)
            .votes(votes)
            .page(page)
            .pageSize(pageSize)
    }
}