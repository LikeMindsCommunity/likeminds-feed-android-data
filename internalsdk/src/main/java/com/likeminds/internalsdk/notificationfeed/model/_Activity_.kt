package com.likeminds.internalsdk.notificationfeed.model

import com.google.gson.annotations.SerializedName

class _Activity_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("action")
    val action: Int,
    @SerializedName("action_by")
    val actionBy: List<String>,
    @SerializedName("action_on")
    val actionOn: String,
    @SerializedName("activity_text")
    val activityText: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("cta")
    val cta: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("entity_owner_id")
    val entityOwnerId: String,
    @SerializedName("entity_type")
    val entityType: Int,
    @SerializedName("is_read")
    val isRead: Boolean,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("activity_entity_data")
    val activityEntityData: _ActivityEntityData_?,
    @SerializedName("uuid")
    val uuid: String
) {
    class Builder {
        private var id: String = ""
        private var action: Int = 0
        private var actionBy: List<String> = emptyList()
        private var actionOn: String = ""
        private var activityText: String = ""
        private var createdAt: Long = 0L
        private var cta: String = ""
        private var entityId: String = ""
        private var entityOwnerId: String = ""
        private var entityType: Int = 0
        private var isRead: Boolean = false
        private var updatedAt: Long = 0L
        private var activityEntityData: _ActivityEntityData_? = null
        private var uuid: String = ""

        fun id(id: String) = apply { this.id = id }
        fun action(action: Int) = apply { this.action = action }
        fun actionBy(actionBy: List<String>) = apply { this.actionBy = actionBy }
        fun actionOn(actionOn: String) = apply { this.actionOn = actionOn }
        fun activityText(activityText: String) = apply { this.activityText = activityText }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun cta(cta: String) = apply { this.cta = cta }
        fun entityId(entityId: String) = apply { this.entityId = entityId }
        fun entityOwnerId(entityOwnerId: String) = apply { this.entityOwnerId = entityOwnerId }
        fun entityType(entityType: Int) = apply { this.entityType = entityType }
        fun isRead(isRead: Boolean) = apply { this.isRead = isRead }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun activityEntityData(activityEntityData: _ActivityEntityData_?) =
            apply { this.activityEntityData = activityEntityData }

        fun uuid(uuid: String) = apply { this.uuid = uuid }

        fun build() = _Activity_(
            id,
            action,
            actionBy,
            actionOn,
            activityText,
            createdAt,
            cta,
            entityId,
            entityOwnerId,
            entityType,
            isRead,
            updatedAt,
            activityEntityData,
            uuid
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .action(action)
            .actionBy(actionBy)
            .actionOn(actionOn)
            .activityText(activityText)
            .createdAt(createdAt)
            .cta(cta)
            .entityId(entityId)
            .entityOwnerId(entityOwnerId)
            .entityType(entityType)
            .isRead(isRead)
            .updatedAt(updatedAt)
            .activityEntityData(activityEntityData)
            .uuid(uuid)
    }
}