package com.likeminds.likemindsfeed.sdk.model

data class Member(
    val id: Int,
    val userUniqueId: String,
    val customTitle: String?,
    val imageUrl: String,
    val isGuest: Boolean,
    val isOwner: Boolean,
    val name: String,
    val organisationName: String?,
    val state: Int,
    val updatedAt: Long,
    val sdkClientInfo: SDKClientInfo,
    val customIntroText: String?,
    val memberSince: String?,
    val questionAnswers: List<QuestionAnswer>?
)