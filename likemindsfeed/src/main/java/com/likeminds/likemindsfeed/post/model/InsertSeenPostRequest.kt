package com.likeminds.likemindsfeed.post.model

class InsertSeenPostRequest private constructor(
    val seenPosts: List<SeenPost>
) {
    class Builder {
        private var seenPosts: List<SeenPost> = emptyList()

        fun seenPosts(seenPosts: List<SeenPost>) = apply {
            this.seenPosts = seenPosts
        }

        fun build() = InsertSeenPostRequest(seenPosts)
    }

    fun toBuilder(): Builder {
        return Builder().seenPosts(seenPosts)
    }

    override fun toString(): String {
        return "InsertSeenPostRequest(seenPosts=$seenPosts)"
    }
}