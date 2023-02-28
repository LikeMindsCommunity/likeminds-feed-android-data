package com.likeminds.likemindsfeed.comment.model

import com.likeminds.internalsdk.post.model.Comment
import com.likeminds.likemindsfeed.sdk.model.User

data class GetCommentResponse(
    var success: Boolean,
    var errorMessage: String?,
    var data: CommentData?
)

data class CommentData(
    var comment: Comment,
    var users: Map<String, User>
)