package com.likeminds.internalsdk.db.model

import androidx.room.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Entity(tableName = LMFeedDbConstants.ATTACHMENT_TABLE)
class AttachmentEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "attachment_type")
    val attachmentType: Int,
    @Embedded
    val attachmentMeta: AttachmentMetaEntity,
    @ColumnInfo(name = "post_id")
    val postId: String,
    @ColumnInfo(name = "temp_id")
    val temporaryId: String?
) {
    class Builder {
        private var id: Long = 0
        private var attachmentType: Int = 0
        private var attachmentMeta: AttachmentMetaEntity = AttachmentMetaEntity.Builder().build()
        private var temporaryId: String? = null
        private var postId: String = temporaryId.toString()

        fun id(id: Long) = apply { this.id = id }
        fun attachmentType(attachmentType: Int) = apply { this.attachmentType = attachmentType }
        fun attachmentMeta(attachmentMeta: AttachmentMetaEntity) =
            apply { this.attachmentMeta = attachmentMeta }

        fun postId(postId: String) = apply { this.postId = postId }
        fun temporaryId(temporaryId: String?) = apply { this.temporaryId = temporaryId }

        fun build() = AttachmentEntity(
            id,
            attachmentType,
            attachmentMeta,
            postId,
            temporaryId
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .attachmentType(attachmentType)
            .attachmentMeta(attachmentMeta)
            .postId(postId)
            .temporaryId(temporaryId)
    }

    override fun toString(): String {
        return buildString {
            append("AttachmentEntity:(id:'")
            append(id)
            append("', attachmentType='")
            append(attachmentType)
            append("', attachmentMeta='")
            append(attachmentMeta)
            append("', postId='")
            append(postId)
            append("', temporaryId='")
            append(temporaryId)
            append("'`)")
        }
    }
}