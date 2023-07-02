package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

class _PostReportRequest_ private constructor(
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("uuid")
    val uuid: String,
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
        private var uuid: String = ""

        @EntityType
        private var entityType: Int = POST
        private var tagId: Int = 0
        private var reason: String? = null

        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun uuid(uuid: String) =
            apply { this.uuid = uuid }

        fun entityType(@EntityType entityType: Int) = apply { this.entityType = entityType }
        fun tagId(tagId: Int) = apply { this.tagId = tagId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = _PostReportRequest_(
            entityId,
            uuid,
            entityType,
            tagId,
            reason
        )
    }

    fun toBuilder(): Builder {
        return Builder().entityId(entityId)
            .uuid(uuid)
            .entityType(entityType)
            .tagId(tagId)
            .reason(reason)
    }
}