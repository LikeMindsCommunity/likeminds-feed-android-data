package com.likeminds.likemindsfeed.notificationfeed.model

import com.likeminds.likemindsfeed.comment.model.Comment
import com.likeminds.likemindsfeed.post.model.Attachment

class ActivityEntityData private constructor(
    val id: String,
    val text: String,
    val deleteReason: String?,
    val deletedBy: String?,
    val heading: String?,
    val attachments: List<Attachment>?,
    val communityId: Int,
    val isEdited: Boolean,
    val isPinned: Boolean?,
    val postId: String?,
    val userId: String,
    val replies: List<Comment>?,
    val level: Int?,
    val createdAt: Long,
    val updatedAt: Long,
    val uuid: String,
    val deletedByUUID: String?
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var deleteReason: String? = null
        private var deletedBy: String? = null
        private var heading: String? = null
        private var attachments: List<Attachment>? = null
        private var communityId: Int = 0
        private var isEdited: Boolean = false
        private var isPinned: Boolean? = null
        private var postId: String? = null
        private var userId: String = ""
        private var replies: List<Comment>? = null
        private var level: Int? = null
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var uuid: String = ""
        private var deletedByUUID: String? = null

        fun id(id: String) = apply { this.id = id }
        fun text(text: String) = apply { this.text = text }
        fun deleteReason(deleteReason: String?) = apply { this.deleteReason = deleteReason }
        fun deletedBy(deletedBy: String?) = apply { this.deletedBy = deletedBy }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun isEdited(isEdited: Boolean) = apply { this.isEdited = isEdited }
        fun isPinned(isPinned: Boolean?) = apply { this.isPinned = isPinned }
        fun postId(postId: String?) = apply { this.postId = postId }
        fun userId(userId: String) = apply { this.userId = userId }
        fun replies(replies: List<Comment>?) = apply { this.replies = replies }
        fun level(level: Int?) = apply { this.level = level }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun deletedByUUID(deletedByUUID: String?) = apply { this.deletedByUUID = deletedByUUID }

        fun build() = ActivityEntityData(
            id,
            text,
            deleteReason,
            deletedBy,
            heading,
            attachments,
            communityId,
            isEdited,
            isPinned,
            postId,
            userId,
            replies,
            level,
            createdAt,
            updatedAt,
            uuid,
            deletedByUUID
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .text(text)
            .deleteReason(deleteReason)
            .deletedBy(deletedBy)
            .heading(heading)
            .attachments(attachments)
            .communityId(communityId)
            .isEdited(isEdited)
            .isPinned(isPinned)
            .postId(postId)
            .userId(userId)
            .replies(replies)
            .level(level)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .uuid(uuid)
            .deletedByUUID(deletedByUUID)
    }
}