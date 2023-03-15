package com.likeminds.internalsdk.moderation.model

import com.google.gson.annotations.SerializedName

class _PostReportRequest_ private constructor(
    @SerializedName("entity_id")
    var entityId: String,
    @SerializedName("entity_creator_id")
    var entityCreatorId: String,
    @SerializedName("entity_type")
    @EntityType
    var entityType: Int,
    @SerializedName("link")
    var link: String?,
    @SerializedName("tag_id")
    var tagId: Int,
    @SerializedName("reason")
    var reason: String?
) {

    class Builder {
        private var entityId: String = ""
        private var entityCreatorId: String = ""

        @EntityType
        private var entityType: Int = POST
        private var link: String? = null
        private var tagId: Int = 0
        private var reason: String? = null

        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun entityCreatorId(entityCreatorId: String) =
            apply { this.entityCreatorId = entityCreatorId }

        fun entityType(@EntityType entityType: Int) = apply { this.entityType = entityType }
        fun link(link: String?) = apply { this.link = link }
        fun tagId(tagId: Int) = apply { this.tagId = tagId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = _PostReportRequest_(
            entityId,
            entityCreatorId,
            entityType,
            link,
            tagId,
            reason
        )
    }

    fun toBuilder(): Builder {
        return Builder().entityId(entityId)
            .entityCreatorId(entityCreatorId)
            .entityType(entityType)
            .link(link)
            .tagId(tagId)
            .reason(reason)
    }
}