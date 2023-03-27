package com.likeminds.internalsdk.helper.model

import com.google.gson.annotations.SerializedName

data class _GetTaggingListResponse_(
    @SerializedName("members")
    var members: List<_TagMember_>
)

data class _TagMember_(
    @SerializedName("id")
    var id: Int,
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("is_guest")
    var isGuest: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("user_unique_id")
    var userUniqueId: String
)