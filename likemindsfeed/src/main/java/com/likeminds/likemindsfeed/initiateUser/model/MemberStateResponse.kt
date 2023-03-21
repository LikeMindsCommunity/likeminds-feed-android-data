package com.likeminds.likemindsfeed.initiateUser.model

data class MemberStateResponse(
    var id: Int,
    var state: Int,
    var userUniqueId: String,
    var customTitle: String,
    var imageUrl: String,
    var isGuest: String,
    var isOwner: String,
    var name: String,
    var organisationName: String?,
    var updatedAt: Long
)