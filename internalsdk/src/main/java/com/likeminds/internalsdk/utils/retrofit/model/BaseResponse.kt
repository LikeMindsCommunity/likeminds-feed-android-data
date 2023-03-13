package com.likeminds.internalsdk.utils.retrofit.model

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?
)