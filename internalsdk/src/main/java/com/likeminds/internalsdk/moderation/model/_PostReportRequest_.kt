package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

class _PostReportRequest_ private constructor(
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("entity_creator_id")
    val entityCreatorId: String,
    @SerializedName("entity_type")
    @EntityType
    val entityType: Int,
    @SerializedName("tag_id")
    val tagId: Int,
    @SerializedName("reason")
    val reason: String?
) {
    class Builder {
        private var entityId: String = ""
        private var entityCreatorId: String = ""

        @EntityType
        private var entityType: Int = POST
        private var tagId: Int = 0
        private var reason: String? = null

        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun entityCreatorId(entityCreatorId: String) =
            apply { this.entityCreatorId = entityCreatorId }

        fun entityType(@EntityType entityType: Int) = apply { this.entityType = entityType }
        fun tagId(tagId: Int) = apply { this.tagId = tagId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = _PostReportRequest_(
            entityId,
            entityCreatorId,
            entityType,
            tagId,
            reason
        )
    }

    fun toBuilder(): Builder {
        return Builder().entityId(entityId)
            .entityCreatorId(entityCreatorId)
            .entityType(entityType)
            .tagId(tagId)
            .reason(reason)
    }
}