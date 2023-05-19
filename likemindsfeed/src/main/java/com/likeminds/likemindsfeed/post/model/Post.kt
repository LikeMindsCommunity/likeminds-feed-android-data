package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.comment.model.Comment

data class Post(
    val id: String,
    val text: String,
    val attachments: List<Attachment>?,
    val communityId: Int,
    val isLiked: Boolean,
    val isEdited: Boolean,
    val isPinned: Boolean,
    val userId: String,
    val likesCount: Int,
    val commentsCount: Int,
    val isSaved: Boolean,
    val menuItems: List<MenuItem>,
    val replies: List<Comment>?,
    val createdAt: Long,
    val updatedAt: Long
)