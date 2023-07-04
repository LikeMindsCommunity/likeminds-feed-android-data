package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _Like_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("uuid")
    val uuid: String
) {
    class Builder {
        private var id: String = ""
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var userId: String = ""
        private var uuid: String = ""

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun userId(userId: String) = apply { this.userId = userId }
        fun uuid(uuid: String) = apply { this.uuid = uuid }

        fun build() = _Like_(id, createdAt, updatedAt, userId, uuid)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .userId(userId)
            .uuid(uuid)
    }
}