package com.likeminds.likemindsfeed.universalfeed.model

import com.likeminds.likemindsfeed.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.widgets.model.Widgets

data class GetFeedResponse(
    val posts: List<Post>,
    val users: Map<String, User>,
    val widgets: Map<String, Widgets>
)