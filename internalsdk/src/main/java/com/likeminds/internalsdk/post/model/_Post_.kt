package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _Post_ private constructor(
    @SerializedName("_id")
    var id: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("attachments")
    var attachments: List<_Attachment_>?,
    @SerializedName("community_id")
    var communityId: Int,
    @SerializedName("is_liked")
    var isLiked: Boolean,
    @SerializedName("is_pinned")
    var isPinned: Boolean,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("likes_count")
    var likesCount: Int,
    @SerializedName("comments_count")
    var commentsCount: Int,
    @SerializedName("is_saved")
    var isSaved: Boolean,
    @SerializedName("menu_items")
    var menuItems: List<_MenuItem_>,
    @SerializedName("replies")
    var replies: List<_Comment_>?,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long
) {

    class Builder {

        private var id: String = ""
        private var text: String = ""
        private var attachments: List<_Attachment_>? = null
        private var communityId: Int = 0
        private var isLiked: Boolean = false
        private var isPinned: Boolean = false
        private var userId: String = ""
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var isSaved: Boolean = false
        private var menuItems: List<_MenuItem_> = listOf()
        private var replies: List<_Comment_>? = null
        private var createdAt: Long = 0
        private var updatedAt: Long = 0

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun isPinned(isPinned: Boolean) = apply { this.isPinned = isPinned }
        fun userId(userId: String) = apply { this.userId = userId }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentsCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun isSaved(isSaved: Boolean) = apply { this.isSaved = isSaved }
        fun menuItems(menuItems: List<_MenuItem_>) = apply { this.menuItems = menuItems }
        fun replies(replies: List<_Comment_>?) = apply { this.replies = replies }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }

        fun build() = _Post_(
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