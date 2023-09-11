package com.likeminds.likemindsfeed.widgets.model

class Widgets private constructor(
    val id: String,
    val createdAt: Long,
    val metaData: MetaData?,
    val parentEntityId: String,
    val parentEntityType: String,
    val updatedAt: Long
) {
    class Builder {
        private var id: String = ""
        private var createdAt: Long = 0L
        private var metaData: MetaData? = null
        private var parentEntityId: String = ""
        private var parentEntityType: String = ""
        private var updatedAt: Long = 0L

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun metaData(metaData: MetaData?) = apply { this.metaData = metaData }
        fun parentEntityId(parentEntityId: String) = apply { this.parentEntityId = parentEntityId }
        fun parentEntityType(parentEntityType: String) =
            apply { this.parentEntityType = parentEntityType }

        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }

        fun build() = Widgets(
            id,
            createdAt,
            metaData,
            parentEntityId,
            parentEntityType,
            updatedAt
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .metaData(metaData)
            .parentEntityId(parentEntityId)
            .parentEntityType(parentEntityType)
            .updatedAt(updatedAt)
    }
}