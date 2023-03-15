package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model.Post
import com.likeminds.internalsdk.sdk.model._User_

data class _GetFeedResponse_(
    @SerializedName("posts")
    var posts: List<Post>,
    @SerializedName("users")
    var users: Map<String, _User_>
)