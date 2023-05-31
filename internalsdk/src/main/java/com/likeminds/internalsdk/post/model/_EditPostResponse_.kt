package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _EditPostResponse_(
    @SerializedName("post")
    val post: _Post_,
    @SerializedName("users")
    val users: Map<String, _User_>
)