package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

data class _GetReportTagsResponse_ constructor(
    @SerializedName("report_tags")
    var tags: List<_ReportTag_>
)

data class _ReportTag_(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)
