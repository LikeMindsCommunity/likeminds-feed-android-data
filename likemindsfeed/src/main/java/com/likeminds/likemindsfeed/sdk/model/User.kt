package com.likeminds.likemindsfeed.sdk.model

// TODO Confirm about creating duplicates or reusing the same
data class User(
    var id: String,
    var imageUrl: String,
    var isGuest: Boolean,
    var name: String,
    var organisationName: String?,
    var sdkClientInfo: SDKClientInfo?,
    var updatedAt: Long,
    var userUniqueId: String
)

data class SDKClientInfo(
    var community: Int,
    var user: Int,
    var userUniqueId: String
)
