package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class Comment private constructor(
    @SerializedName("_id")
    var id: String,
    @SerializedName("is_liked")
    var isLiked: Boolean,
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
    var replies: List<Comment>,
    @SerializedName("menu_items")
    var menuItems: List<MenuItem>,
    @SerializedName("parent_id")
    var parentId: String?
)