package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

data class _GetReportTagsResponse_ constructor(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("error_message")
    var errorMessage: String?,
    @SerializedName("data")
    var data: _ReportTagsData_?
)

data class _ReportTagsData_(
    @SerializedName("report_tags")
    var tags: List<_ReportTag_>
)

data class _ReportTag_(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)
