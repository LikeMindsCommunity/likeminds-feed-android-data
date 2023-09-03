package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _Member_(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_unique_id")
    val userUniqueId: String,
    @SerializedName("custom_title")
    val customTitle: String?,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("is_guest")
    val isGuest: Boolean,
    @SerializedName("is_owner")
    val isOwner: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("organisation_name")
    val organisationName: String?,
    @SerializedName("state")
    val state: Int,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("sdk_client_info")
    val sdkClientInfo: _SDKClientInfo_,
    @SerializedName("custom_intro_text")
    val customIntroText: String?,
    @SerializedName("member_since")
    val memberSince: String?,
    @SerializedName("question_answers")
    val questionAnswers: List<_QuestionAnswer_>?
)