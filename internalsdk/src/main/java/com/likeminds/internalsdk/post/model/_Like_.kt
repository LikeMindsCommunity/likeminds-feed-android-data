package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class _Like_(
    @SerializedName("_id")
    var id: String,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("user_id")
    var userId: String
)