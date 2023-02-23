package com.likeminds.likemindsfeed.moderation.model

import com.likeminds.internalsdk.moderation.model.ReportTagsData

data class GetReportTagsResponse constructor(
    var success: Boolean,
    var errorMessage: String?,
    var data: ReportTagsData? = null
)
