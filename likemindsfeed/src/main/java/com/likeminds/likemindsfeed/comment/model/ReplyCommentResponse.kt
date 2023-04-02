package com.likeminds.likemindsfeed.comment.model

import com.likeminds.likemindsfeed.sdk.model.User

data class ReplyCommentResponse(
    var comment: Comment,
    var users: Map<String, User>
)