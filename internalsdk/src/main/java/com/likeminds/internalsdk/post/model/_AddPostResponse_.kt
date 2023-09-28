package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.topic.model._Topic_
import com.likeminds.internalsdk.widgets.model._Widget_

data class _AddPostResponse_(
    @SerializedName("post")
    val post: _Post_,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widget_>,
    @SerializedName("topics")
    val topics: Map<String, _Topic_>
)