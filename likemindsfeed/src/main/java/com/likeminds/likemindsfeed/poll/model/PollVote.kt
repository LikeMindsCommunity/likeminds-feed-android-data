package com.likeminds.likemindsfeed.poll.model

class PollVote private constructor(
    val id: String,
    val userIds: List<String>
) {
    class Builder {
        private var id: String = ""
        private var userIds: List<String> = emptyList()

        fun id(id: String) = apply { this.id = id }
        fun userIds(userIds: List<String>) = apply { this.userIds = userIds }

        fun build() = PollVote(id, userIds)
    }

    override fun toString(): String {
        return "PollVote(id:$id, userIds:$userIds)"
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .userIds(userIds)
    }
}