package com.likeminds.likemindsfeed.universalfeed.model

import com.likeminds.likemindsfeed.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.User

data class GetFeedResponse(
    var posts: List<Post>,
    var users: Map<String, User>
)