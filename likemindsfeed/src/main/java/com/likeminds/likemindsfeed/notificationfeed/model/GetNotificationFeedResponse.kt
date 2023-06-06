package com.likeminds.likemindsfeed.notificationfeed.model

import com.likeminds.likemindsfeed.comment.model.Comment
import com.likeminds.likemindsfeed.post.model.Attachment

data class GetNotificationFeedResponse(
    val activities: List<Activity>
)

data class Activity(
    val id: String,
    val action: Int,
    val actionBy: List<String>,
    val actionOn: String,
    val activityText: String,
    val createdAt: Long,
    val cta: String,
    val entityId: String,
    val entityOwnerId: String,
    val entityType: Int,
    val isRead: Boolean,
    val updatedAt: Long,
    val activityEntityData: ActivityEntityData,
//    todo:
//    @SerializedName("activity_user_data")
)

data class ActivityEntityData(
    val id: String,
    val text: String,
    val deleteReason: String,
    val deletedBy: String,
    val heading: String,
    val attachments: List<Attachment>?,
    val communityId: Int,
    val isEdited: Boolean,
    val isPinned: Boolean,
    val userId: String,
    val replies: List<Comment>?,
    val level: Int,
    val createdAt: Long,
    val updatedAt: Long
)