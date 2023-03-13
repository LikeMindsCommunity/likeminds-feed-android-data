package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _InitiateUserResponse_(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _InitiateUserResponseData_?
)

data class _InitiateUserResponseData_(
    @SerializedName("community")
    var community: _Community_,
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("refresh_token")
    var refreshToken: String,
    @SerializedName("user")
    var user: _User_,
    @SerializedName("app_access")
    var appAccess: Boolean,
    @SerializedName("has_answers")
    var hasAnswers: Boolean?
)