package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.comment.model._Comment_
import com.likeminds.internalsdk.post.model._Attachment_
import com.likeminds.internalsdk.sdk.model._User_

data class _GetNotificationFeedResponse_(
    @SerializedName("activities")
    val activities: List<_Activity_>,
    @SerializedName("users")
    val users: Map<String, _User_>
)

data class _Activity_(
    @SerializedName("_id")
    val id: String,
    @SerializedName("action")
    val action: Int,
    @SerializedName("action_by")
    val actionBy: List<String>,
    @SerializedName("action_on")
    val actionOn: String,
    @SerializedName("activity_text")
    val activityText: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("cta")
    val cta: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("entity_owner_id")
    val entityOwnerId: String,
    @SerializedName("entity_type")
    val entityType: Int,
    @SerializedName("is_read")
    val isRead: Boolean,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("activity_entity_data")
    val activityEntityData: _ActivityEntityData_
)

data class _ActivityEntityData_(
    @SerializedName("_id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("delete_reason")
    val deleteReason: String,
    @SerializedName("deleted_by")
    val deletedBy: String,
    @SerializedName("heading")
    val heading: String,
    @SerializedName("attachments")
    val attachments: List<_Attachment_>?,
    @SerializedName("community_id")
    val communityId: Int,
    @SerializedName("is_liked")
    val isEdited: Boolean,
    @SerializedName("is_pinned")
    val isPinned: Boolean,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("replies")
    val replies: List<_Comment_>?,
    @SerializedName("level")
    val level: Int,
    // todo: String to Long
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)