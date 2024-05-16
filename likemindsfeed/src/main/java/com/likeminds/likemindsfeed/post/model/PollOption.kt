package com.likeminds.likemindsfeed.post.model

class PollOption private constructor(
    val id: String,
    val text: String,
    val isSelected: Boolean,
    val percentage: Float,
    val uuid: String,
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

        fun build() = PollOption(
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