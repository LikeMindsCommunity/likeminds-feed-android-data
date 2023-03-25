package com.likeminds.likemindsfeed.helper.model

data class GetTaggingListResponse(
    var members: List<TagMember>
)

data class TagMember(
    var id: Int,
    var imageUrl: String,
    var isGuest: Boolean,
    var name: String,
    var userUniqueId: String,
)