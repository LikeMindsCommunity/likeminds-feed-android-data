package com.likeminds.internalsdk.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.POST_TABLE, primaryKeys = ["temp_id", "post_id"])
class PostEntity(
    @ColumnInfo(name = "temp_id")
    var temporaryId: String,
    @ColumnInfo(name = "text")
    var text: String?,
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String?,
    @ColumnInfo(name = "worker_uuid")
    var workerUUID: String,
    @ColumnInfo(name = "is_posted")
    var isPosted: Boolean,
    @ColumnInfo(name = "post_id")
    var postId: String
) {
    class Builder {
        private var temporaryId: String = ""
        private var text: String? = null
        private var thumbnail: String? = null
        private var workerUUID: String = ""
        private var isPosted: Boolean = false
        private var postId: String = temporaryId

        fun temporaryId(temporaryId: String) = apply { this.temporaryId = temporaryId }
        fun text(text: String?) = apply { this.text = text }
        fun thumbnail(thumbnail: String?) = apply { this.thumbnail = thumbnail }
        fun workerUUID(workerUUID: String) = apply { this.workerUUID = workerUUID }
        fun isPosted(isPosted: Boolean) = apply { this.isPosted = isPosted }
        fun postId(postId: String) = apply {
            this.postId = postId
        }

        fun build() =
            PostEntity(
                temporaryId,
                text,
                thumbnail,
                workerUUID,
                isPosted,
                postId
            )
    }

    fun toBuilder(): Builder {
        return Builder().temporaryId(temporaryId)
            .text(text)
            .thumbnail(thumbnail)
            .workerUUID(workerUUID)
            .isPosted(isPosted)
            .postId(postId)
    }

    override fun toString(): String {
        return buildString {
            append("PostEntity:(temporaryId=")
            append(temporaryId)
            append(", text=")
            append(text)
            append(", thumbnail=")
            append(thumbnail)
            append(", workerUUID=")
            append(workerUUID)
            append(", isPosted=")
            append(isPosted)
            append(", postId=")
            append(postId)
            append(")")
        }
    }
}