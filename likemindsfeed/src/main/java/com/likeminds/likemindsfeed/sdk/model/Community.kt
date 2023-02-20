package com.likeminds.likemindsfeed.sdk.model

data class Community(
    var id: String,
    var name: String,
    var imageUrl: String?,
    var membersCount: Int?,
    var updatedAt: String?,
    var createdBy: String?,
    var managedBy: String?,
    var menu: List<String>?
)
