package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _DeletePostRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String,
    @SerializedName("delete_reason")
    var deleteReason: String?,
) {

    class Builder {
        private var postId: String = ""
        private var deleteReason: String? = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun deleteReason(deleteReason: String?) = apply { this.deleteReason = deleteReason }

        fun build() = _DeletePostRequest_(postId, deleteReason)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .deleteReason(deleteReason)
    }
}