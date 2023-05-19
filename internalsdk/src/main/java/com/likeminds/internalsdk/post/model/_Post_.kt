package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.comment.model._Comment_

data class _Post_(
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
    val updatedAt: Long
)