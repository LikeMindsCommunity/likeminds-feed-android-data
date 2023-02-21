package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _Post_(
    @SerializedName("_id")
    var id: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("attachments")
    var attachments: List<_Attachment_>,
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
    var menuItems: List<_MenuItem_>,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("users")
    var user: Map<String, _User_>
)