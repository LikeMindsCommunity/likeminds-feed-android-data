package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User

data class EditPostResponse(
    val post: Post,
    val users: Map<String, User>
)