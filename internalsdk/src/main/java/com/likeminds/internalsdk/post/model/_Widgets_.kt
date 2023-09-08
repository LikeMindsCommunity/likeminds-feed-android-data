package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class _Widgets_(
    @SerializedName("_id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("meta_data")
    val metaData: _MetaData_?,
    @SerializedName("parent_entity_id")
    val parentEntityId: String,
    @SerializedName("parent_entity_type")
    val parentEntityType: String,
    @SerializedName("updated_at")
    val updatedAt: Long
)

data class _MetaData_(
    @SerializedName("body")
    val body: String,
    @SerializedName("cover_image_url")
    val coverImageUrl: String,
    @SerializedName("title")
    val title: String
)