package com.likeminds.likemindsfeed.initiateUser.model

data class MemberStateResponse(
    var id: Int,
    var state: Int,
    var userUniqueId: String,
    var customTitle: String,
    var imageUrl: String,
    var isGuest: Boolean,
    var isOwner: Boolean,
    var name: String,
    var organisationName: String?,
    var managerRights: List<ManagementRightPermissionData>?,
    var memberRights: List<ManagementRightPermissionData>,
    var updatedAt: Long
)