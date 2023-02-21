package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class _AddPostResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
)