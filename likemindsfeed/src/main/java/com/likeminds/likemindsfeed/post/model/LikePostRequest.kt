package com.likeminds.likemindsfeed.post.model

class LikePostRequest private constructor(
    val postId: String,
) {
    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = LikePostRequest(postId)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}