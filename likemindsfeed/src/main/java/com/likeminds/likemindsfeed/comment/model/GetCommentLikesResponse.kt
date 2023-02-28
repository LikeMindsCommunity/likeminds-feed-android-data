package com.likeminds.likemindsfeed.comment.model

import com.likeminds.internalsdk.post.model.Like
import com.likeminds.likemindsfeed.sdk.model.User

data class GetCommentLikesResponse(
    var success: Boolean,
    var errorMessage: String?,
    var data: CommentLikesData?
)

data class CommentLikesData(
    var likes: List<Like>,
    var totalCount: Int,
    var users: Map<String, User>
)