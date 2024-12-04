package com.likeminds.internalsdk.search.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Post_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.topic.model._Topic_
import com.likeminds.internalsdk.widgets.model._Widget_

data class _SearchPostsResponse_(
    @SerializedName("posts")
    val posts: List<_Post_>,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widget_>,
    @SerializedName("topics")
    val topics: Map<String, _Topic_>
)