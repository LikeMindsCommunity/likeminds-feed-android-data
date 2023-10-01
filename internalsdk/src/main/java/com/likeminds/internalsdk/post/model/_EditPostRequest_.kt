package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _EditPostRequest_ private constructor(
    @SerializedName("post_id")
    val postId: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("heading")
    val heading: String?,
    @SerializedName("entity_id")
    val entityId: String?,
    @SerializedName("attachments")
    val attachments: List<_Attachment_>?,
    @SerializedName("topic_ids")
    val topicIds: List<String>?
) {
    class Builder {
        private var postId: String? = null
        private var text: String? = null
        private var heading: String? = null
        private var entityId: String? = null
        private var attachments: List<_Attachment_>? = null
        private var topicIds: List<String>? = null

        fun postId(postId: String?) = apply { this.postId = postId }
        fun text(text: String?) = apply { this.text = text }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun entityId(entityId: String?) = apply { this.entityId = entityId }
        fun attachments(attachments: List<_Attachment_>?) = apply { this.attachments = attachments }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }

        fun build() = _EditPostRequest_(
            postId,
            text,
            heading,
            entityId,
            attachments,
            topicIds
        )
    }

    fun toBuilder(): Builder {
        return Builder().postId(postId)
            .text(text)
            .heading(heading)
            .entityId(entityId)
            .attachments(attachments)
            .topicIds(topicIds)
    }
}