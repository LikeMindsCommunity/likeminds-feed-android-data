package com.likeminds.likemindsfeed.initiateUser.model

import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.LogoutResponse
import com.likeminds.likemindsfeed.sdk.model.User

data class InitiateUserResponse(
    var accessToken: String,
    var refreshToken: String,
    var user: User, //user data
    var community: Community, //community data
    var appAccess: Boolean?,
    var logoutResponse: LogoutResponse? = null, //logout data
)