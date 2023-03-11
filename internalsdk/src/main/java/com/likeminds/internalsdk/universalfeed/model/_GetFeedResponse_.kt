package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Post_
import com.likeminds.internalsdk.sdk.model._User_

data class _GetFeedResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _FeedData_?
)

data class _FeedData_(
    @SerializedName("posts")
    var posts: List<_Post_>,
    @SerializedName("users")
    var users: Map<String, _User_>
)