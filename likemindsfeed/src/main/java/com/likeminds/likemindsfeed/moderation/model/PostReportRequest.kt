package com.likeminds.likemindsfeed.moderation.model

class PostReportRequest private constructor(
    var entityId: String,
    var entityCreatorId: String,
    var entityType: Int,
    var link: String?,
    var tagId: Int,
    var reason: String?
) {

    class Builder {
        private var entityId: String = ""
        private var entityCreatorId: String = ""
        private var entityType: Int = 5
        private var link: String? = null
        private var tagId: Int = 0
        private var reason: String? = null

        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun entityCreatorId(entityCreatorId: String) =
            apply { this.entityCreatorId = entityCreatorId }

        fun entityType(entityType: Int) = apply { this.entityType = entityType }
        fun link(link: String?) = apply { this.link = link }
        fun tagId(tagId: Int) = apply { this.tagId = tagId }
        fun reason(reason: String?) = apply { this.reason = reason }

        fun build() = PostReportRequest(
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