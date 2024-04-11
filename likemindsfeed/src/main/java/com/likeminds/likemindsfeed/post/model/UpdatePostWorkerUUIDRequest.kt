package com.likeminds.likemindsfeed.post.model

class UpdatePostWorkerUUIDRequest private constructor(
    val temporaryId: String,
    val workerUUID: String
) {
    class Builder {
        private var temporaryId: String = ""
        private var workerUUID: String = ""

        fun temporaryId(temporaryId: String) = apply {
            this.temporaryId = temporaryId
        }

        fun workerUUID(workerUUID: String) = apply {
            this.workerUUID = workerUUID
        }

        fun build() = UpdatePostWorkerUUIDRequest(temporaryId, workerUUID)
    }

    fun toBuilder(): Builder {
        return Builder().temporaryId(temporaryId)
            .workerUUID(workerUUID)
    }
}