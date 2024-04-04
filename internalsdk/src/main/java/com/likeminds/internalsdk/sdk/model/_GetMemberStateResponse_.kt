package com.likeminds.internalsdk.sdk.model

import com.google.gson.annotations.SerializedName

data class _GetMemberStateResponse_(
    @SerializedName("state")
    val state: Int,
    @SerializedName("member")
    val member: _Member_?,
    @SerializedName("manager_rights")
    val managerRights: List<_ManagementRightPermissionData_>?,
    @SerializedName("member_rights")
    val memberRights: List<_ManagementRightPermissionData_>,
)

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
    val sdkClientInfo: _SDKClientInfo_
)