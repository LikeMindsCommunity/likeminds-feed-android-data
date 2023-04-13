package com.likeminds.likemindsfeed.initiateUser.model

data class ManagementRightPermissionData(
    var id: Int,
    var isLocked: Boolean?,
    var isSelected: Boolean?,
    var state: Int?,
    var title: String,
    var subtitle: String?
)