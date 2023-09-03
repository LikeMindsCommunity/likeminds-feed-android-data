package com.likeminds.likemindsfeed.community.model

import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.Member

data class GetAllMembersResponse(
    val community: Community,
    val members: List<Member>,
    val totalFilteredMembers: Int,
    val totalMembers: Int,
    val totalOnlyMembers: Int,
    val totalPendingMembers: Int
)