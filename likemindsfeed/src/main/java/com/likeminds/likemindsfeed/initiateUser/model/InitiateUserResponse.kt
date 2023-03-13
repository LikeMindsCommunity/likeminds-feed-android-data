package com.likeminds.likemindsfeed.initiateUser.model

import com.likeminds.likemindsfeed.sdk.model.LogoutResponse

data class InitiateUserResponse(
    var success: Boolean,
    var errorMessage: String?,
    var appAccess: Boolean?,
    var initiateUser: InitiateUser?, //initiate user
    var logoutResponse: LogoutResponse? = null, //logout data
)