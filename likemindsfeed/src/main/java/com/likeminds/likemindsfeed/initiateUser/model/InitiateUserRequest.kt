package com.likeminds.likemindsfeed.initiateUser.model

data class InitiateUserRequest(
    var userName: String?,
    var userId: String?,
    var isGuest: Boolean?
)