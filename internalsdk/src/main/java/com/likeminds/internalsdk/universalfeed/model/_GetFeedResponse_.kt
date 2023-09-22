package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Post_
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.widgets.model._Widgets_

data class _GetFeedResponse_(
    @SerializedName("posts")
    val posts: List<_Post_>,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widgets_>
)