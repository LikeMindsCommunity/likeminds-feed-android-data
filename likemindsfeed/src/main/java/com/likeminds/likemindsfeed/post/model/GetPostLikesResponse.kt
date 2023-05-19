package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User

data class GetPostLikesResponse(
    val likes: List<Like>,
    val totalCount: Int,
    val users: Map<String, User>
)