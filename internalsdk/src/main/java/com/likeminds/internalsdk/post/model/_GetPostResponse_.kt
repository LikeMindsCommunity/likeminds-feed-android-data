package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _GetPostResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _PostData_?
)

data class _PostData_(
    @SerializedName("post")
    var post: _Post_,
    @SerializedName("users")
    var users: Map<String, _User_>
)