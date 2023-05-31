package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _AddCommentResponse_(
    @SerializedName("comment")
    val comment: _Comment_,
    @SerializedName("users")
    val users: Map<String, _User_>
)