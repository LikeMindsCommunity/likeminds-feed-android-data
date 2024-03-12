package com.likeminds.likemindsfeed.user.model

data class ManagementRightPermissionData(
    val id: Int,
    val isLocked: Boolean?,
    val isSelected: Boolean,
    val state: Int,
    val title: String,
    val subtitle: String?
)