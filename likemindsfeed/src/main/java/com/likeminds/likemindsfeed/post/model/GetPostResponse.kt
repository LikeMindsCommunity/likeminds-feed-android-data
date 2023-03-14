package com.likeminds.likemindsfeed.post.model

import com.likeminds.internalsdk.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.User

data class GetPostResponse(
    var post: Post?,
    var users: Map<String, User>?
)