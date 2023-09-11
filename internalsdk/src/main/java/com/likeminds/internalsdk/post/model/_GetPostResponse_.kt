package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_
import com.likeminds.internalsdk.widgets.model._Widgets_

data class _GetPostResponse_(
    @SerializedName("post")
    val post: _Post_,
    @SerializedName("users")
    val users: Map<String, _User_>,
    @SerializedName("widgets")
    val widgets: Map<String, _Widgets_>
)