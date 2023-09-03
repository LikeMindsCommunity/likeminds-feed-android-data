package com.likeminds.internalsdk.community.model

import com.google.gson.annotations.SerializedName
import com.likeminds.internalsdk.sdk.model._Community_
import com.likeminds.internalsdk.sdk.model._Member_

data class _GetAllMembersResponse_(
    @SerializedName("community")
    val community: _Community_,
    @SerializedName("members")
    val members: List<_Member_>,
    @SerializedName("total_filtered_members")
    val totalFilteredMembers: Int,
    @SerializedName("total_members")
    val totalMembers: Int,
    @SerializedName("total_only_members")
    val totalOnlyMembers: Int,
    @SerializedName("total_pending_members")
    val totalPendingMembers: Int
)