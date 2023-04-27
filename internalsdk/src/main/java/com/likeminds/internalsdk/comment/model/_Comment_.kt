package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._MenuItem_

data class _Comment_(
    @SerializedName("_id")
    var id: String,
    @SerializedName("is_liked")
    var isLiked: Boolean,
    @SerializedName("is_edited")
    var isEdited: Boolean,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("level")
    var level: Int,
    @SerializedName("likes_count")
    var likesCount: Int,
    @SerializedName("comments_count")
    var commentsCount: Int,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("replies")
    var replies: List<_Comment_>?,
    @SerializedName("menu_items")
    var menuItems: List<_MenuItem_>,
    @SerializedName("parent_comment")
    var parentComment: _Comment_?
)