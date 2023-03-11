package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _Like_ private constructor(
    @SerializedName("_id")
    var id: String,
    @SerializedName("created_at")
    var createdAt: Long,
    @SerializedName("updated_at")
    var updatedAt: Long,
    @SerializedName("user_id")
    var userId: String
) {

    class Builder {

        private var id: String = ""
        private var createdAt: Long = 0
        private var updatedAt: Long = 0
        private var userId: String = ""

        fun id(id: String) = apply { this.id = id }
        fun createdAt(createdAt: Long) = apply { this.createdAt = createdAt }
        fun updatedAt(updatedAt: Long) = apply { this.updatedAt = updatedAt }
        fun userId(userId: String) = apply { this.userId = userId }

        fun build() = _Like_(
            id,
            createdAt,
            updatedAt,
            userId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .userId(userId)
    }
}