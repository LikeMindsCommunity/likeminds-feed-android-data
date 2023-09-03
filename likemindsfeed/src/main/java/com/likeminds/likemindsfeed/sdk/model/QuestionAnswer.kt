package com.likeminds.likemindsfeed.sdk.model

data class QuestionAnswer(
    val communityId: Int,
    val directoryFields: Boolean,
    val isHidden: Boolean,
    val memberId: String,
    val questionId: Int,
    val questionTitle: String,
    val state: Int,
    val tag: String,
    val value: String,
)