package com.likeminds.likemindsfeed.initiateUser.model

import com.likeminds.likemindsfeed.sdk.model.Community
import com.likeminds.likemindsfeed.sdk.model.User

data class InitiateUser constructor(
    var user: User, //user data
    var community: Community, //community data
)