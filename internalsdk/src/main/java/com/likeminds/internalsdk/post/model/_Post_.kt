package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.comment.model._Comment_

class _Post_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("attachments")
    val attachments: List<_Attachment_>?,
    @SerializedName("community_id")
    val communityId: Int,
    @SerializedName("is_liked")
    val isLiked: Boolean,
    @SerializedName("is_edited")
    val isEdited: Boolean,
    @SerializedName("is_pinned")
    val isPinned: Boolean,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("likes_count")
    val likesCount: Int,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("is_saved")
    val isSaved: Boolean,
    @SerializedName("menu_items")
    val menuItems: List<_MenuItem_>,
    @SerializedName("replies")
    val replies: List<_Comment_>?,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("heading")
    val heading: String?,
    @SerializedName("temp_id")
    val tempId: Long?,
    @SerializedName("topics")
    val topicIds: List<String>?
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var attachments: List<_Attachment_>? = null
        private var communityId: Int = 0
        private var isLiked: Boolean = false
        private var isEdited: Boolean = false
        private var isPinned: Boolean = false
        private var userId: String = ""
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var isSaved: Boolean = false
        private var menuItems: List<_MenuItem_> = emptyList()
        private var replies: List<_Comment_>? = null
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var uuid: String = ""
        private var heading: String? = null
        private var tempId: Long? = null
        private var topicIds: List<String>? = null

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun isLiked(isLiked: Boolean) = apply { this.isLiked = isLiked }
        fun isEdited(isEdited: Boolean) = apply { this.isEdited = isEdited }
        fun isPinned(isPinned: Boolean) = apply { this.isPinned = isPinned }
        fun userId(userId: String) = apply { this.userId = userId }
        fun likesCount(likesCount: Int) = apply { this.likesCount = likesCount }
        fun commentCount(commentsCount: Int) = apply { this.commentsCount = commentsCount }
        fun isSaved(isSaved: Boolean) = apply { this.isSaved = isSaved }
        fun menuItems(menuItems: List<_MenuItem_>) = apply { this.menuItems = menuItems }
        fun replies(replies: List<_Comment_>?) = apply { this.replies = replies }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun tempId(tempId: Long?) = apply { this.tempId = tempId }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }

        fun build() = _Post_(
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
            tempId,
            topicIds
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
            .topicIds(topicIds)
    }
}