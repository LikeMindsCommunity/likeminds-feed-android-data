package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _PollOption_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("is_selected")
    val isSelected: Boolean,
    @SerializedName("percentage")
    val percentage: Float,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("vote_count")
    val voteCount: Int
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var isSelected: Boolean = false
        private var percentage: Float = 0f
        private var uuid: String = ""
        private var voteCount: Int = 0

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun isSelected(isSelected: Boolean) = apply { this.isSelected = isSelected }
        fun percentage(percentage: Float) = apply { this.percentage = percentage }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun voteCount(voteCount: Int) = apply { this.voteCount = voteCount }

        fun build() = _PollOption_(
            id,
            text,
            isSelected,
            percentage,
            uuid,
            voteCount
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .text(text)
            .isSelected(isSelected)
            .percentage(percentage)
            .uuid(uuid)
            .voteCount(voteCount)
    }
}