package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

data class _GetReportTagsResponse_ constructor(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: ReportTagsData?
)

data class ReportTagsData(
    @SerializedName("report_tags")
    var tags: List<ReportTag>
)

data class ReportTag(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)
