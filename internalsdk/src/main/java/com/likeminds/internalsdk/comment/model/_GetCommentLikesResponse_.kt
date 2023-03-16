package com.likeminds.internalsdk.comment.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Like_

import com.likeminds.internalsdk.sdk.model._User_

data class _GetCommentLikesResponse_(
    @SerializedName("likes")
    var likes: List<_Like_>,
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("users")
    var users: Map<String, _User_>
)