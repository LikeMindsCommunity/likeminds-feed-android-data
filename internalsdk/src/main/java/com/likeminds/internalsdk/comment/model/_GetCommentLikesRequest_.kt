package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName

class _GetCommentLikesRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String,
    @SerializedName("comment_id")
    var commentId: String,
    @SerializedName("page")
    var page: Int,
    @SerializedName("page_size")
    var pageSize: Int
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

        fun build() = _GetCommentLikesRequest_(
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