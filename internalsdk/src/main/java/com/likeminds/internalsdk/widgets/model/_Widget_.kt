package com.likeminds.internalsdk.widgets.model

import com.google.gson.annotations.SerializedName

class _Widget_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("metadata")
    val metaData: _WidgetMetaData_?,
    @SerializedName("parent_entity_id")
    val parentEntityId: String,
    @SerializedName("parent_entity_type")
    val parentEntityType: String,
    @SerializedName("updated_at")
    val updatedAt: Long
) {
    class Builder {
        private var id: String = ""
        private var createdAt: Long = 0L
        private var metaData: _WidgetMetaData_? = null
        private var parentEntityId: String = ""
        private var parentEntityType: String = ""
        private var updatedAt: Long = 0L

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun metaData(metaData: _WidgetMetaData_?) = apply { this.metaData = metaData }
        fun parentEntityId(parentEntityId: String) = apply { this.parentEntityId = parentEntityId }
        fun parentEntityType(parentEntityType: String) =
            apply { this.parentEntityType = parentEntityType }

        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }

        fun build() = _Widget_(
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