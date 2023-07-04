package com.likeminds.likemindsfeed.post.model

class Like private constructor(
    val id: String,
    val createdAt: Long,
    val updatedAt: Long,
    val userId: String,
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

        fun build() = Like(id, createdAt, updatedAt, userId, uuid)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .userId(userId)
            .uuid(uuid)
    }
}