package com.likeminds.likemindsfeed.initiateUser.model

data class MemberStateResponse(
    val id: Int,
    val state: Int,
    val userUniqueId: String,
    val customTitle: String?,
    val imageUrl: String,
    val isGuest: Boolean,
    val isOwner: Boolean,
    val name: String,
    val organisationName: String?,
    val managerRights: List<ManagementRightPermissionData>?,
    val memberRights: List<ManagementRightPermissionData>,
    val updatedAt: Long
)