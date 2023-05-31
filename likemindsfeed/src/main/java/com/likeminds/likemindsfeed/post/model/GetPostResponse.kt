package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User

data class GetPostResponse(
    val post: Post,
    val users: Map<String, User>
)