package com.likeminds.likemindsfeed.post.model

class PostSeenRequest private constructor(
    val seenPostIds: List<String>,
) {
    class Builder {
        private var seenPostIds: List<String> = emptyList()

        fun seenPostIds(seenPostIds: List<String>) = apply { this.seenPostIds = seenPostIds }

        fun build() = PostSeenRequest(seenPostIds)
    }

    fun toBuilder(): Builder {
        return Builder().seenPostIds(seenPostIds)
    }
}