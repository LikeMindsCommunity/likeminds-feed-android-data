package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model.Post

data class _GetFeedResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _Posts_?,
)

data class _Posts_(
    @SerializedName("posts")
    var posts: List<Post>
)