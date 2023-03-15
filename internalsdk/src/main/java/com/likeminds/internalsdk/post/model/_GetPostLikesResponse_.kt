package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _GetPostLikesResponse_(
    @SerializedName("likes")
    var likes: List<_Like_>,
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("users")
    var users: Map<String, _User_>
)