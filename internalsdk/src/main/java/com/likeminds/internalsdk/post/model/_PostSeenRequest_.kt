package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _PostSeenRequest_ private constructor(
    @SerializedName("post_ids")
    val seenPostIds: List<String>
) {
    class Builder {
        private var seenPostIds: List<String> = emptyList()

        fun seenPostIds(seenPostIds: List<String>) = apply {
            this.seenPostIds = seenPostIds
        }

        fun build() = _PostSeenRequest_(seenPostIds)
    }

    fun toBuilder(): Builder {
        return Builder().seenPostIds(seenPostIds)
    }
}