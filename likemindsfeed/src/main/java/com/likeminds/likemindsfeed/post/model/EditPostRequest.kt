package com.likeminds.likemindsfeed.post.model

class EditPostRequest private constructor(
    val postId: String,
    val text: String?,
    val heading: String?,
    val entityId: String?,
    val attachments: List<Attachment>?,
    val topicIds: List<String>?
) {
    class Builder {
        private var postId: String = ""
        private var text: String? = null
        private var heading: String? = null
        private var entityId: String? = null
        private var attachments: List<Attachment>? = null
        private var topicIds: List<String>? = null

        fun postId(postId: String) = apply { this.postId = postId }
        fun text(text: String?) = apply { this.text = text }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun entityId(entityId: String?) = apply { this.entityId = entityId }
        fun attachments(attachments: List<Attachment>?) = apply { this.attachments = attachments }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }

        fun build() = EditPostRequest(
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