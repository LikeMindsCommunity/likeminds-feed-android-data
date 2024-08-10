package com.likeminds.internalsdk.db.model

import androidx.room.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.TOPIC_TABLE)
class TopicEntity(
    @ColumnInfo(name = "topic_id")
    @PrimaryKey
    var id: String,
    @ColumnInfo(name = "topic_name")
    var name: String,
    @ColumnInfo(name = "is_topic_enabled")
    var isEnabled: Boolean,
    @ColumnInfo(name = "post_id")
    var postId: String,
) {

    class Builder {
        private var id: String = ""
        private var name: String = ""
        private var isEnabled: Boolean = true
        private var postId: String = ""

        fun id(id: String) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun isEnabled(isEnabled: Boolean) = apply { this.isEnabled = isEnabled }
        fun postId(postId: String) = apply { this.postId = postId }

        fun build() = TopicEntity(id, name, isEnabled, postId)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isEnabled(isEnabled)
            .name(name)
            .postId(postId)
    }

    override fun toString(): String {
        return buildString {
            append("TopicEntity(id='")
            append(id)
            append("', name='")
            append(name)
            append("', isEnabled=")
            append(isEnabled)
            append(", postId='")
            append(postId)
            append("')")
        }
    }
}
