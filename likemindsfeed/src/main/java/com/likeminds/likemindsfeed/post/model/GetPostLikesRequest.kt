package com.likeminds.likemindsfeed.post.model

class GetPostLikesRequest private constructor(
    var postId: String,
) {

    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = GetPostLikesRequest(postId)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}