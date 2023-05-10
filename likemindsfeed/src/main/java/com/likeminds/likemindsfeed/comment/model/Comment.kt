package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.post.model.MenuItem

data class Comment(
    val id: String,
    val isLiked: Boolean,
    val isEdited: Boolean,
    val userId: String,
    val text: String,
    val level: Int,
    val likesCount: Int,
    val commentsCount: Int,
    val createdAt: Long,
    val updatedAt: Long,
    val replies: List<Comment>?,
    val menuItems: List<MenuItem>,
    val parentComment: Comment?
)