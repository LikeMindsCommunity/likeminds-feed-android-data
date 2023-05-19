package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.sdk.model.User

data class GetCommentResponse(
    val comment: Comment,
    val users: Map<String, User>
)