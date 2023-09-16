package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.post.model.MenuItem

class Comment private constructor(
    val id: String,
    val isLiked: Boolean,
    val isEdited: Boolean,
    val userId: String,
    val text: String,
    val level: Int,
    val likesCount: Int,
    val commentsCount: Int,
    val createdAt: Long,
    val updatedAt: Long,
    val replies: List<Comment>?,
    val menuItems: List<MenuItem>,
    val parentComment: Comment?,
    val uuid: String,
    val tempId: Long?
) {
    class Builder {
        private var id: String = ""
        private var isLiked: Boolean = false
        private var isEdited: Boolean = false
        private var userId: String = ""
        private var text: String = ""
        private var level: Int = 0
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var replies: List<Comment>? = null
        private var menuItems: List<MenuItem> = emptyList()
        private var parentComment: Comment? = null
        private var uuid: String = ""
        private var tempId: Long? = null

        fun id(id: String) = apply { this.id = id }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun isEdited(isEdited: Boolean) = apply { this.isEdited = isEdited }
        fun userId(userId: String) = apply { this.userId = userId }
        fun text(text: String) = apply { this.text = text }
        fun level(level: Int) = apply { this.level = level }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentsCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun replies(replies: List<Comment>?) = apply { this.replies = replies }
        fun menuItems(menuItems: List<MenuItem>) = apply { this.menuItems = menuItems }
        fun parentComment(parentComment: Comment?) = apply { this.parentComment = parentComment }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun tempId(tempId: Long?) = apply { this.tempId = tempId }

        fun build() = Comment(
            id,
            isLiked,
            isEdited,
            userId,
            text,
            level,
            likesCount,
            commentsCount,
            createdAt,
            updatedAt,
            replies,
            menuItems,
            parentComment,
            uuid,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isLiked(isLiked)
            .isEdited(isEdited)
            .userId(userId)
            .text(text)
            .level(level)
            .likesCount(likesCount)
            .commentsCount(commentsCount)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .replies(replies)
            .menuItems(menuItems)
            .parentComment(parentComment)
            .uuid(uuid)
            .tempId(tempId)
    }
}