package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.post.model.Like
import com.likeminds.likemindsfeed.sdk.model.User

data class GetCommentLikesResponse(
    val likes: List<Like>,
    val totalCount: Int,
    val users: Map<String, User>
)