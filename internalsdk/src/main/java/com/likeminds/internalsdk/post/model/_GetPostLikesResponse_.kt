package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _GetPostLikesResponse_(
    @SerializedName("likes")
    val likes: List<_Like_>,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("users")
    val users: Map<String, _User_>
)