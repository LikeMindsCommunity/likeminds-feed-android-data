package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model.Like
import com.likeminds.internalsdk.sdk.model._User_

data class _GetCommentLikesResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _CommentLikesData_?
)

data class _CommentLikesData_(
    @SerializedName("likes")
    var likes: List<Like>,
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("users")
    var users: Map<String, _User_>
)