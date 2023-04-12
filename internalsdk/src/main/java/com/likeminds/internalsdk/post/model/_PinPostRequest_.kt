package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _PinPostRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String,
) {

    class Builder {
        private var postId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = _PinPostRequest_(postId)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
    }
}