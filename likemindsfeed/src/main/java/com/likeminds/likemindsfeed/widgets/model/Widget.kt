package com.likeminds.likemindsfeed.widgets.model

import org.json.JSONObject

class Widget private constructor(
    val id: String,
    val createdAt: Long,
    val metadata: JSONObject,
    val parentEntityId: String,
    val parentEntityType: String,
    val updatedAt: Long,
    val lmMeta: LMMeta?
) {
    class Builder {
        private var id: String = ""
        private var createdAt: Long = 0L
        private var metdata: JSONObject = JSONObject()
        private var parentEntityId: String = ""
        private var parentEntityType: String = ""
        private var updatedAt: Long = 0L
        private var lmMeta: LMMeta? = null

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun metadata(widgetMetaData: JSONObject) =
            apply { this.metdata = widgetMetaData }

        fun parentEntityId(parentEntityId: String) = apply { this.parentEntityId = parentEntityId }
        fun parentEntityType(parentEntityType: String) =
            apply { this.parentEntityType = parentEntityType }

        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun lmMeta(lmMeta: LMMeta?) = apply { this.lmMeta = lmMeta }

        fun build() = Widget(
            id,
            createdAt,
            metdata,
            parentEntityId,
            parentEntityType,
            updatedAt,
            lmMeta
        )
    }

    override fun toString(): String {
        return "Widget: metadata:$metadata id: $id"
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .metadata(metadata)
            .parentEntityId(parentEntityId)
            .parentEntityType(parentEntityType)
            .updatedAt(updatedAt)
            .lmMeta(lmMeta)
    }
}