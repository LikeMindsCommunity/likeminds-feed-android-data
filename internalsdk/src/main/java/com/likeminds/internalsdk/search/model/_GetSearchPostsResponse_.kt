package com.likeminds.internalsdk.search.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Post_
import com.likeminds.internalsdk.sdk.model._User_


data class _GetSearchPostsResponse_(
    @SerializedName("posts")
    val posts: List<_Post_>,
    @SerializedName("users")
    val users: Map<String, _User_>
)