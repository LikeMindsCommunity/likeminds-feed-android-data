package com.likeminds.likemindsfeed.post.model

import com.likeminds.internalsdk.post.model.Like
import com.likeminds.likemindsfeed.sdk.model.User

data class GetPostLikesResponse(
    var likes: List<Like>,
    var totalCount: Int,
    var users: Map<String, User>
)