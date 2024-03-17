package com.likeminds.internalsdk.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.POST_TABLE, primaryKeys = ["temp_id", "post_id"])
class PostEntity constructor(
    @ColumnInfo(name = "temp_id")
    var temporaryId: String,
    @ColumnInfo(name = "text")
    var text: String?,
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String?,
    @ColumnInfo(name = "uuid")
    var uuid: String,
    @ColumnInfo(name = "is_posted")
    var isPosted: Boolean,
    @ColumnInfo(name = "post_id")
    var postId: String
) {
    class Builder {
        private var temporaryId: String = ""
        private var text: String? = null
        private var thumbnail: String? = null
        private var uuid: String = ""
        private var isPosted: Boolean = false
        private var postId: String = temporaryId

        fun temporaryId(temporaryId: String) = apply { this.temporaryId = temporaryId }
        fun text(text: String?) = apply { this.text = text }
        fun thumbnail(thumbnail: String?) = apply { this.thumbnail = thumbnail }
        fun uuid(uuid: String) = apply { this.uuid = uuid }
        fun isPosted(isPosted: Boolean) = apply { this.isPosted = isPosted }
        fun postId(postId: String) = apply {
            this.postId = postId
        }

        fun build() =
            PostEntity(
                temporaryId,
                text,
                thumbnail,
                uuid,
                isPosted,
                postId
            )
    }

    fun toBuilder(): Builder {
        return Builder().temporaryId(temporaryId)
            .text(text)
            .thumbnail(thumbnail)
            .uuid(uuid)
            .isPosted(isPosted)
            .postId(postId)
    }
}