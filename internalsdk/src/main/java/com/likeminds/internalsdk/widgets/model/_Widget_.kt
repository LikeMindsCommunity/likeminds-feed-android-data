package com.likeminds.internalsdk.widgets.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class _Widget_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("metadata")
    val metadata: JsonObject,
    @SerializedName("parent_entity_id")
    val parentEntityId: String,
    @SerializedName("parent_entity_type")
    val parentEntityType: String,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("_lm_meta")
    val lmMeta: _LMMeta_?
) {
    class Builder {
        private var id: String = ""
        private var createdAt: Long = 0L
        private var metaData: JsonObject = JsonObject()
        private var parentEntityId: String = ""
        private var parentEntityType: String = ""
        private var updatedAt: Long = 0L
        private var lmMeta: _LMMeta_? = null

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun metaData(metaData: JsonObject) = apply { this.metaData = metaData }
        fun parentEntityId(parentEntityId: String) = apply { this.parentEntityId = parentEntityId }
        fun parentEntityType(parentEntityType: String) =
            apply { this.parentEntityType = parentEntityType }

        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun lmMeta(lmMeta: _LMMeta_?) = apply { this.lmMeta = lmMeta }

        fun build() = _Widget_(
            id,
            createdAt,
            metaData,
            parentEntityId,
            parentEntityType,
            updatedAt,
            lmMeta
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .metaData(metadata)
            .parentEntityId(parentEntityId)
            .parentEntityType(parentEntityType)
            .updatedAt(updatedAt)
            .lmMeta(lmMeta)
    }
}