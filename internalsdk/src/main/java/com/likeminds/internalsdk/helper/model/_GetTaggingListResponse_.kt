package com.likeminds.internalsdk.helper.model

import com.google.gson.annotations.SerializedName

data class _GetTaggingListResponse_(
    @SerializedName("members")
    val members: List<_TagMember_>
)

data class _TagMember_(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("is_guest")
    val isGuest: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("user_unique_id")
    val userUniqueId: String
)