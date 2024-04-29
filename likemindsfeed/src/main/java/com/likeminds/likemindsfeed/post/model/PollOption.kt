package com.likeminds.likemindsfeed.post.model

class PollOption private constructor(
    val id: String,
    val isSelected: Boolean,
    val percentage: Int,
    val uuid: String,
    val voteCount: Int
) {
    class Builder {
        private var id: String = ""
        private var isSelected: Boolean = false
        private var percentage: Int = 0
        private var uuid: String = ""
        private var voteCount: Int = 0

        fun id(id: String) = apply { this.id = id }
        fun isSelected(isSelected: Boolean) = apply { this.isSelected = isSelected }
        fun percentage(percentage: Int) = apply { this.percentage = percentage }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun voteCount(voteCount: Int) = apply { this.voteCount = voteCount }

        fun build() = PollOption(id, isSelected, percentage, uuid, voteCount)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isSelected(isSelected)
            .percentage(percentage)
            .uuid(uuid)
            .voteCount(voteCount)
    }
}