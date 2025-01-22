package com.likeminds.internalsdk.db.model

import androidx.room.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.POST_SEEN_TABLE)
class PostSeenEntity(
    @PrimaryKey
    @ColumnInfo(name = "post_id")
    var postId: String,
    @ColumnInfo(name = "seen_at")
    var seenAt: Long
) {
    class Builder {
        private var postId: String = ""
        private var seenAt: Long = 0L

        fun postId(postId: String) = apply { this.postId = postId }
        fun seenAt(seenAt: Long) = apply { this.seenAt = seenAt }

        fun build() = PostSeenEntity(postId, seenAt)
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .seenAt(seenAt)
    }
}