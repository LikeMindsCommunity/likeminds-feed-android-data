package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("_id")
    var id: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("attachments")
    var attachments: List<Attachment>?,
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
    var menuItems: List<MenuItem>,
    @SerializedName("replies")
    var replies: List<Comment>,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long
)