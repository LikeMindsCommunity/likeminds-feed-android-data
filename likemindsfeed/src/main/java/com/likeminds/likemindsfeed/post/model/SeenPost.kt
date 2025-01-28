package com.likeminds.likemindsfeed.post.model

class SeenPost private constructor(
    val postId: String,
    val seenAt: Long
) {
    class Builder {
        private var postId: String = ""
        private var seenAt: Long = 0L

        fun postId(postId: String) = apply {
            this.postId = postId
        }

        fun seenAt(seenAt: Long) = apply {
            this.seenAt = seenAt
        }

        fun build() = SeenPost(postId, seenAt)
    }

    fun toBuilder(): Builder {
        return Builder().seenAt(seenAt).postId(postId)
    }

    override fun toString(): String {
        return "SeenPost(postId='$postId', seenAt=$seenAt)"
    }
}