package com.likeminds.likemindsfeed.sdk.model

data class Community(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val membersCount: Int?,
    val updatedAt: String?
)
