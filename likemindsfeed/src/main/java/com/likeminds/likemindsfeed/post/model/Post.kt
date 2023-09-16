package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.comment.model.Comment

class Post private constructor(
    val id: String,
    val text: String,
    val attachments: List<Attachment>?,
    val communityId: Int,
    val isLiked: Boolean,
    val isEdited: Boolean,
    val isPinned: Boolean,
    val userId: String,
    val likesCount: Int,
    val commentsCount: Int,
    val isSaved: Boolean,
    val menuItems: List<MenuItem>,
    val replies: List<Comment>?,
    val createdAt: Long,
    val updatedAt: Long,
    val uuid: String,
    val heading: String?,
    val tempId: Long?
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var attachments: List<Attachment>? = null
        private var communityId: Int = 0
        private var isLiked: Boolean = false
        private var isEdited: Boolean = false
        private var isPinned: Boolean = false
        private var userId: String = ""
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var isSaved: Boolean = false
        private var menuItems: List<MenuItem> = emptyList()
        private var replies: List<Comment>? = null
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var uuid: String = ""
        private var heading: String? = null
        private var tempId: Long? = null

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun isEdited(isEdited: Boolean) = apply { this.isEdited = isEdited }
        fun isPinned(isPinned: Boolean) = apply { this.isPinned = isPinned }
        fun userId(userId: String) = apply { this.userId = userId }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun isSaved(isSaved: Boolean) = apply { this.isSaved = isSaved }
        fun menuItems(menuItems: List<MenuItem>) = apply { this.menuItems = menuItems }
        fun replies(replies: List<Comment>?) = apply { this.replies = replies }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun tempId(tempId: Long?) = apply { this.tempId = tempId }

        fun build() = Post(
            id,
            text,
            attachments,
            communityId,
            isLiked,
            isEdited,
            isPinned,
            userId,
            likesCount,
            commentsCount,
            isSaved,
            menuItems,
            replies,
            createdAt,
            updatedAt,
            uuid,
            heading,
            tempId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .text(text)
            .attachments(attachments)
            .communityId(communityId)
            .isLiked(isLiked)
            .isEdited(isEdited)
            .isPinned(isPinned)
            .userId(userId)
            .likesCount(likesCount)
            .commentCount(commentsCount)
            .isSaved(isSaved)
            .menuItems(menuItems)
            .replies(replies)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .uuid(uuid)
            .heading(heading)
            .tempId(tempId)
    }
}