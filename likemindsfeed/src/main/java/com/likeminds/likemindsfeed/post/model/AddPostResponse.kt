package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User

data class AddPostResponse(
    val post: Post,
    val users: Map<String, User>,
    val widgets: Map<String, Widgets>
)