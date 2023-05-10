package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _GetCommentRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String,
    @SerializedName("comment_id")
    val commentId: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int
) {
    class Builder {
        private var postId: String = ""
        private var commentId: String = ""
        private var page: Int = 1
        private var pageSize: Int = 10

        fun postId(postId: String) = apply { this.postId = postId }
        fun commentId(commentId: String) = apply { this.commentId = commentId }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = _GetCommentRequest_(
            postId,
            commentId,
            page,
            pageSize
        )
    }

    fun toBuilder(): Builder {
        return Builder().commentId(commentId)
            .postId(postId)
            .page(page)
            .pageSize(pageSize)
    }
}