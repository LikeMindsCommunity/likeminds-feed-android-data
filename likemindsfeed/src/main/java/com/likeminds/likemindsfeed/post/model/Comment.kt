package com.likeminds.likemindsfeed.post.model

class Comment private constructor(
    var id: String,
    var isLiked: Boolean,
    var userId: String,
    var text: String,
    var level: Int,
    var likesCount: Int,
    var commentsCount: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var menuItems: List<MenuItem>,
    var parentId: String?
) {

    class Builder {

        private var id: String = ""
        private var isLiked: Boolean = false
        private var userId: String = ""
        private var text: String = ""
        private var level: Int = 0
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var createdAt: Long = 0
        private var updatedAt: Long = 0
        private var menuItems: List<MenuItem> = listOf()
        private var parentId: String? = null

        fun id(id: String) = apply { this.id = id }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun userId(userId: String) = apply { this.userId = userId }
        fun text(text: String) = apply { this.text = text }
        fun level(level: Int) = apply { this.level = level }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentsCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun menuItems(menuItems: List<MenuItem>) = apply { this.menuItems = menuItems }
        fun parentId(parentId: String?) = apply { this.parentId = parentId }

        fun build() = Comment(
            id,
            isLiked,
            userId,
            text,
            level,
            likesCount,
            commentsCount,
            createdAt,
            updatedAt,
            menuItems,
            parentId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isLiked(isLiked)
            .userId(userId)
            .text(text)
            .level(level)
            .likesCount(likesCount)
            .commentsCount(commentsCount)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .menuItems(menuItems)
            .parentId(parentId)
    }
}