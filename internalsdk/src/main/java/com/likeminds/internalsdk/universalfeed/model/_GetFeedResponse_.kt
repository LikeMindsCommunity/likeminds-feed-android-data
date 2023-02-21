package com.likeminds.internalsdk.universalfeed.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.post.model._Post_

data class _GetFeedResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _Feed_?,
)

data class _Feed_(
    @SerializedName("feed")
    var posts: List<_Post_>
)