package com.likeminds.likemindsfeed.post.model

class Post private constructor(
    var id: String,
    var text: String,
    var attachments: List<Attachment>?,
    var communityId: Int,
    var isLiked: Boolean,
    var isPinned: Boolean,
    var userId: String,
    var likesCount: Int,
    var commentsCount: Int,
    var isSaved: Boolean,
    var menuItems: List<MenuItem>,
    var replies: List<Comment>?,
    var createdAt: Long,
    var updatedAt: Long
) {

    class Builder {

        private var id: String = ""
        private var text: String = ""
        private var attachments: List<Attachment>? = null
        private var communityId: Int = 0
        private var isLiked: Boolean = false
        private var isPinned: Boolean = false
        private var userId: String = ""
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var isSaved: Boolean = false
        private var menuItems: List<MenuItem> = listOf()
        private var replies: List<Comment>? = null
        private var createdAt: Long = 0
        private var updatedAt: Long = 0

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun isPinned(isPinned: Boolean) = apply { this.isPinned = isPinned }
        fun userId(userId: String) = apply { this.userId = userId }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentsCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun isSaved(isSaved: Boolean) = apply { this.isSaved = isSaved }
        fun menuItems(menuItems: List<MenuItem>) = apply { this.menuItems = menuItems }
        fun replies(replies: List<Comment>?) = apply { this.replies = replies }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }

        fun build() = Post(
            id,
            text,
            attachments,
            communityId,
            isLiked,
            isPinned,
            userId,
            likesCount,
            commentsCount,
            isSaved,
            menuItems,
            replies,
            createdAt,
            updatedAt
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .text(text)
            .attachments(attachments)
            .communityId(communityId)
            .isLiked(isLiked)
            .isPinned(isPinned)
            .userId(userId)
            .likesCount(likesCount)
            .commentsCount(commentsCount)
            .isSaved(isSaved)
            .menuItems(menuItems)
            .replies(replies)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
    }
}