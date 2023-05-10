package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._MenuItem_

data class _Comment_(
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
    val parentComment: _Comment_?
)