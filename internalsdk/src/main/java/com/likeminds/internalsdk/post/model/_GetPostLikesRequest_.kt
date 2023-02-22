package com.likeminds.internalsdk.post.model

class _GetPostLikesRequest_ private constructor(
    var postId: String,
) {

    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = _GetPostLikesRequest_(
            postId
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}