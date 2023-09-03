package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _QuestionAnswer_(
    @SerializedName("community_id")
    val communityId: Int,
    @SerializedName("directory_fields")
    val directoryFields: Boolean,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("member_id")
    val memberId: String,
    @SerializedName("question_id")
    val questionId: Int,
    @SerializedName("question_title")
    val questionTitle: String,
    @SerializedName("state")
    val state: Int,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("value")
    val value: String,
)