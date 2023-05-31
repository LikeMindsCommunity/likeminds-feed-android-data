package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class _Like_(
    @SerializedName("_id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("user_id")
    val userId: String
)