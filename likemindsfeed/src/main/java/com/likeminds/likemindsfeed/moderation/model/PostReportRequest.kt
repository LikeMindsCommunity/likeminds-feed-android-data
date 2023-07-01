package com.likeminds.likemindsfeed.moderation.model

class PostReportRequest private constructor(
    var entityId: String,
    var uuid: String,
    var entityType: Int,
    var tagId: Int,
    var reason: String?
) {

    class Builder {
        private var entityId: String = ""
        private var uuid: String = ""
        private var entityType: Int = -1
        private var tagId: Int = -1
        private var reason: String? = null

        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun entityCreatorId(entityCreatorId: String) =
            apply { this.uuid = entityCreatorId }

        fun entityType(entityType: Int) = apply { this.entityType = entityType }
        fun tagId(tagId: Int) = apply { this.tagId = tagId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = PostReportRequest(
            entityId,
            uuid,
            entityType,
            tagId,
            reason
        )
    }

    fun toBuilder(): Builder {
        return Builder().entityId(entityId)
            .entityCreatorId(uuid)
            .entityType(entityType)
            .tagId(tagId)
            .reason(reason)
    }
}