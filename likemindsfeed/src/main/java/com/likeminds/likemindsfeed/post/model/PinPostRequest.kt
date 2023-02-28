package com.likeminds.likemindsfeed.post.model

class PinPostRequest private constructor(
    var postId: String,
) {

    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = PinPostRequest(postId)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}