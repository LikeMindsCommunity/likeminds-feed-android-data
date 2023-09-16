package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._MenuItem_

class _Comment_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_liked")
    val isLiked: Boolean,
    @SerializedName("is_edited")
    val isEdited: Boolean,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("level")
    val level: Int,
    @SerializedName("likes_count")
    val likesCount: Int,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("replies")
    val replies: List<_Comment_>?,
    @SerializedName("menu_items")
    val menuItems: List<_MenuItem_>,
    @SerializedName("parent_comment")
    val parentComment: _Comment_?,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("temp_id")
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
        private var replies: List<_Comment_>? = null
        private var menuItems: List<_MenuItem_> = emptyList()
        private var parentComment: _Comment_? = null
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
        fun replies(replies: List<_Comment_>?) = apply { this.replies = replies }
        fun menuItems(menuItems: List<_MenuItem_>) = apply { this.menuItems = menuItems }
        fun parentComment(parentComment: _Comment_?) = apply { this.parentComment = parentComment }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun tempId(tempId: Long?) = apply { this.tempId = tempId }

        fun build() = _Comment_(
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