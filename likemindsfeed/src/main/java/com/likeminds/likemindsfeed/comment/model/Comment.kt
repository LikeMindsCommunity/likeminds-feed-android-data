package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.post.model.MenuItem

data class Comment(
    var id: String,
    var isLiked: Boolean,
    var userId: String,
    var text: String,
    var level: Int,
    var likesCount: Int,
    var commentsCount: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var replies: List<Comment>?,
    var menuItems: List<MenuItem>,
    var parentId: String?
)