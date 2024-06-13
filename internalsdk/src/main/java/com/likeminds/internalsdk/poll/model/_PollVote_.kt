package com.likeminds.internalsdk.poll.model

import com.google.gson.annotations.SerializedName

class _PollVote_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("users")
    val userIds: List<String>
) {
    class Builder {
        private var id: String = ""
        private var userIds: List<String> = emptyList()

        fun id(id: String) = apply { this.id = id }
        fun userIds(userIds: List<String>) = apply { this.userIds = userIds }

        fun build() = _PollVote_(id, userIds)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .userIds(userIds)
    }
}