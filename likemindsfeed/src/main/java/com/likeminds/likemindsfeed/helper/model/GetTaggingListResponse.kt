package com.likeminds.likemindsfeed.helper.model

data class GetTaggingListResponse(
    val members: List<TagMember>
)

data class TagMember(
    val id: Int,
    val imageUrl: String,
    val isGuest: Boolean,
    val name: String,
    val userUniqueId: String,
)