package com.likeminds.likemindsfeed.universalfeed.model

import com.likeminds.internalsdk.post.model.Post

data class GetFeedResponse(
    var success: Boolean,
    var errorMessage: String?,
    var data: Posts? = null,
)

data class Posts(
    var posts: List<Post>?
)