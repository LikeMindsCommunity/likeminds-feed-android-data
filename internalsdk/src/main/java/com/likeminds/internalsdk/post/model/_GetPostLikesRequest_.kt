package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _GetPostLikesRequest_ private constructor(
    @SerializedName("post_id")
    var postId: String,
    @SerializedName("page")
    var page: Int,
    @SerializedName("page_size")
    var pageSize: Int
) {

    class Builder {
        private var postId: String = ""
        private var page: Int = 1
        private var pageSize: Int = 10

        fun postId(postId: String) = apply { this.postId = postId }
        fun page(page: Int) = apply { this.page = page }
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        fun build() = _GetPostLikesRequest_(
            postId,
            page,
            pageSize
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .page(page)
            .pageSize(pageSize)
    }
}