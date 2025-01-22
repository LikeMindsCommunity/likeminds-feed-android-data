package com.likeminds.likemindsfeed.post.model

class RemoveSeenPostRequest private constructor(
    val minimumSeenAt: Long
) {
    class Builder {
        private var minimumSeenAt: Long = 0L

        fun minimumSeenAt(minimumSeenAt: Long) = apply {
            this.minimumSeenAt = minimumSeenAt
        }

        fun build() = RemoveSeenPostRequest(minimumSeenAt)
    }

    fun toBuilder(): Builder {
        return Builder().minimumSeenAt(minimumSeenAt)
    }
}