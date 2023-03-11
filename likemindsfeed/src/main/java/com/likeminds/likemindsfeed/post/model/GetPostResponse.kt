package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User

data class GetPostResponse(
    var success: Boolean,
    var errorMessage: String?,
    var data: PostData? = null
)

data class PostData(
    var post: Post?,
    var users: Map<String, User>?
)