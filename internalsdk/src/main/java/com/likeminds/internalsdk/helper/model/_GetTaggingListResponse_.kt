package com.likeminds.internalsdk.helper.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _GetTaggingListResponse_(
    @SerializedName("members")
    val members: List<_User_>
)