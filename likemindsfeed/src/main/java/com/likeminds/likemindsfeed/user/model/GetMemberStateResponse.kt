package com.likeminds.likemindsfeed.user.model

data class GetMemberStateResponse(
    val id: Int,
    val state: Int,
    val userUniqueId: String,
    val customTitle: String?,
    val imageUrl: String,
    val isGuest: Boolean,
    val name: String,
    val organisationName: String?,
    val managerRights: List<ManagementRightPermissionData>?,
    val memberRights: List<ManagementRightPermissionData>,
    val updatedAt: Long,
    val uuid: String
)