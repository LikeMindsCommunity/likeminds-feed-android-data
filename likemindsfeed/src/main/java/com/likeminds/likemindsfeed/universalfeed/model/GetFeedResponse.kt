package com.likeminds.likemindsfeed.universalfeed.model

import com.likeminds.likemindsfeed.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.User

data class GetFeedResponse(
    val posts: List<Post>,
    val users: Map<String, User>
)