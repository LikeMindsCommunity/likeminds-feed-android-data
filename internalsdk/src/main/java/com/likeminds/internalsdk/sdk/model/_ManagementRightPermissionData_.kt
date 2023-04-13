package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _ManagementRightPermissionData_(
    @SerializedName("id")
    var id: Int,
    @SerializedName("is_locked")
    var isLocked: Boolean?,
    @SerializedName("is_selected")
    var isSelected: Boolean,
    @SerializedName("state")
    var state: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("sub_title")
    var subtitle: String?
)