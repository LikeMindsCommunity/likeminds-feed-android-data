package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class InitiateResponse(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: Boolean?,
    @SerializedName("data")
    var data: InitiateResponseData?
)

data class InitiateResponseData(
//    @SerializedName("community")
//    var community: Community,
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("refresh_token")
    var refreshToken: String,
    @SerializedName("user")
    var user: User,
    @SerializedName("app_access")
    var appAccess: Boolean,
    @SerializedName("has_answers")
    var hasAnswers: Boolean?
)