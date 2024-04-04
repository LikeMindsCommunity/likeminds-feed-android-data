package com.likeminds.likemindsfeed.moderation.model

data class GetReportTagsResponse(
    val tags: List<ReportTag>
)

data class ReportTag(
    val id: Int,
    val name: String
)
