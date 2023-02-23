package com.likeminds.likemindsfeed.moderation.model

import com.likeminds.internalsdk.moderation.model._ReportTagsData_

data class GetReportTagsResponse constructor(
    var success: Boolean,
    var errorMessage: String?,
    var data: _ReportTagsData_? = null
)
