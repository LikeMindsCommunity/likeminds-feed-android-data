package com.likeminds.internalsdk.community.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._User_

data class _SearchMembersResponse_(
    @SerializedName("members")
    val members: List<_User_>
)