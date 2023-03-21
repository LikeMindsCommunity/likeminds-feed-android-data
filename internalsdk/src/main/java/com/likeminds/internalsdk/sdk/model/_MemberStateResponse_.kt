package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _MemberStateResponse_(
    @SerializedName("state")
    var state: Int,
    @SerializedName("member")
    var member: _Member_?
)

data class _Member_(
    @SerializedName("id")
    var id: Int,
    @SerializedName("user_unique_id")
    var userUniqueId: String,
    @SerializedName("custom_title")
    var customTitle: String,
    @SerializedName("image_url")
    var imageUrl: String,
    @SerializedName("is_guest")
    var isGuest: String,
    @SerializedName("is_owner")
    var isOwner: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("organisation_name")
    var organisationName: String?,
    @SerializedName("state")
    var state: Int,
    @SerializedName("updated_at")
    var updatedAt: Long
)