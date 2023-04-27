package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.comment.model.Comment

data class Post(
    var id: String,
    var text: String,
    var attachments: List<Attachment>?,
    var communityId: Int,
    var isLiked: Boolean,
    var isEdited: Boolean,
    var isPinned: Boolean,
    var userId: String,
    var likesCount: Int,
    var commentsCount: Int,
    var isSaved: Boolean,
    var menuItems: List<MenuItem>,
    var replies: List<Comment>?,
    var createdAt: Long,
    var updatedAt: Long
)