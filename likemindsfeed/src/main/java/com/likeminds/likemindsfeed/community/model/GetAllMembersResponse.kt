package com.likeminds.likemindsfeed.community.model

import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.User

data class GetAllMembersResponse(
    val community: Community,
    val members: List<User>,
    val totalFilteredMembers: Int,
    val totalMembers: Int,
    val totalOnlyMembers: Int,
    val totalPendingMembers: Int
)