package com.likeminds.likemindsfeed.user.model

import com.likeminds.likemindsfeed.LMResponse
import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.User

data class InitiateUserResponse(
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val user: User? = null, //user data
    val community: Community? = null, //community data
    val appAccess: Boolean?,
    val logoutResponse: LMResponse<Nothing>? = null, //logout data
)