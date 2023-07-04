package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.comment.model._Comment_
import com.likeminds.internalsdk.post.model._Attachment_

class _ActivityEntityData_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("delete_reason")
    val deleteReason: String?,
    @SerializedName("deleted_by")
    val deletedBy: String?,
    @SerializedName("heading")
    val heading: String?,
    @SerializedName("attachments")
    val attachments: List<_Attachment_>?,
    @SerializedName("community_id")
    val communityId: Int,
    @SerializedName("is_liked")
    val isEdited: Boolean,
    @SerializedName("is_pinned")
    val isPinned: Boolean?,
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("replies")
    val replies: List<_Comment_>?,
    @SerializedName("level")
    val level: Int?,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("deleted_by_uuid")
    val deletedByUUID: String?
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var deleteReason: String? = null
        private var deletedBy: String? = null
        private var heading: String? = null
        private var attachments: List<_Attachment_>? = null
        private var communityId: Int = 0
        private var isEdited: Boolean = false
        private var isPinned: Boolean? = null
        private var postId: String? = null
        private var userId: String = ""
        private var replies: List<_Comment_>? = null
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
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }
        fun communityId(communityId: Int) = apply { this.communityId = communityId }
        fun isEdited(isEdited: Boolean) = apply { this.isEdited = isEdited }
        fun isPinned(isPinned: Boolean?) = apply { this.isPinned = isPinned }
        fun postId(postId: String?) = apply { this.postId = postId }
        fun userId(userId: String) = apply { this.userId = userId }
        fun replies(replies: List<_Comment_>?) = apply { this.replies = replies }
        fun level(level: Int?) = apply { this.level = level }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun deletedByUUID(deletedByUUID: String?) = apply { this.deletedByUUID = deletedByUUID }

        fun build() = _ActivityEntityData_(
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