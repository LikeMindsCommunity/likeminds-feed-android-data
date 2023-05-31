package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _LikePostRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String,
) {
    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = _LikePostRequest_(postId)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}