package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _Comment_ private constructor(
    @SerializedName("_id")
    var id: String,
    @SerializedName("is_liked")
    var isLiked: Boolean,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("level")
    var level: Int,
    @SerializedName("likes_count")
    var likesCount: Int,
    @SerializedName("comments_count")
    var commentsCount: Int,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("menu_items")
    var menuItems: List<_MenuItem_>,
    @SerializedName("parent_id")
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
        private var menuItems: List<_MenuItem_> = listOf()
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
        fun menuItems(menuItems: List<_MenuItem_>) = apply { this.menuItems = menuItems }
        fun parentId(parentId: String?) = apply { this.parentId = parentId }

        fun build() = _Comment_(
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