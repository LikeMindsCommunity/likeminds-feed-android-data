package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model.Comment
import com.likeminds.internalsdk.sdk.model._User_

data class _GetCommentResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _CommentData_?
)

data class _CommentData_(
    @SerializedName("comment")
    var comment: Comment,
    @SerializedName("users")
    var users: Map<String, _User_>
)