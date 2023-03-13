package com.likeminds.likemindsfeed.sdk.model

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
