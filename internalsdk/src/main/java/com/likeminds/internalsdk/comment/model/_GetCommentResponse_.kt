package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model.Comment
import com.likeminds.internalsdk.sdk.model._User_

data class _GetCommentResponse_(
    @SerializedName("comment")
    var comment: Comment,
    @SerializedName("users")
    var users: Map<String, _User_>
)