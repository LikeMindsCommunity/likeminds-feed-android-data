package com.likeminds.likemindsfeed.community.model

import com.likeminds.likemindsfeed.sdk.model.User

data class SearchMembersResponse(
    val members: List<User>
)