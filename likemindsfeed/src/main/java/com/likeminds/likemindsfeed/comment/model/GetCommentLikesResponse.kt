package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.post.model.Like
import com.likeminds.likemindsfeed.sdk.model.User

data class GetCommentLikesResponse(
    var likes: List<Like>,
    var totalCount: Int,
    var users: Map<String, User>
)