package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _LikeCommentRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String,
    @SerializedName("comment_id")
    var commentId: String
) {

    class Builder {
        private var postId: String = ""
        private var commentId: String = ""

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }

        fun build() = _LikeCommentRequest_(
            postId,
            commentId
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
    }
}