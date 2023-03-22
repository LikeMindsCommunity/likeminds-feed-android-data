package com.likeminds.likemindsfeed.post.model

class DeletePostRequest private constructor(
    var postId: String,
    var deleteReason: String?,
) {

    class Builder {
        private var postId: String = ""
        private var deleteReason: String? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun deleteReason(deleteReason: String?) = apply { this.deleteReason = deleteReason }

        fun build() = DeletePostRequest(postId, deleteReason)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .deleteReason(deleteReason)
    }
}