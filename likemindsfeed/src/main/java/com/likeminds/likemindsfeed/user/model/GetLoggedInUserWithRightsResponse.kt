package com.likeminds.likemindsfeed.user.model

import com.likeminds.likemindsfeed.sdk.model.User

data class GetLoggedInUserWithRightsResponse(
    val user: User,
    val rights: List<ManagementRightPermissionData>
)
