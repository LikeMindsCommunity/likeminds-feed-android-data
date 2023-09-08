package com.likeminds.likemindsfeed.post.model

data class Widgets(
    val id: String,
    val createdAt: Long,
    val metaData: MetaData,
    val parentEntityId: String,
    val parentEntityType: String,
    val updatedAt: Long
)

data class MetaData(
    val body: String,
    val coverImageUrl: String,
    val name: String,
    val title: String
)