package com.likeminds.likemindsfeed.post.model

class AddPostRequest private constructor(
    val text: String?,
    val onBehalfOfUUID: String?,
    val heading: String?,
    val attachments: List<Attachment>?,
    val tempId: String?,
    val topicIds: List<String>?
) {
    class Builder {
        private var text: String? = null
        private var onBehalfOfUUID: String? = null
        private var heading: String? = null
        private var attachments: List<Attachment>? = null
        private var tempId: String? = null
        private var topicIds: List<String>? = null

        fun text(text: String?) = apply { this.text = text }
        fun onBehalfOfUUID(onBehalfOfUUID: String?) = apply { this.onBehalfOfUUID = onBehalfOfUUID }
        fun heading(heading: String?) = apply { this.heading = heading }
        fun attachments(attachments: List<Attachment>?) =
            apply { this.attachments = attachments }

        fun tempId(tempId: String?) = apply { this.tempId = tempId }
        fun topicIds(topicIds: List<String>?) = apply { this.topicIds = topicIds }

        fun build() = AddPostRequest(
            text,
            onBehalfOfUUID,
            heading,
            attachments,
            tempId,
            topicIds
        )
    }

    fun toBuilder(): Builder {
        return Builder().text(text)
            .onBehalfOfUUID(onBehalfOfUUID)
            .heading(heading)
            .attachments(attachments)
            .tempId(tempId)
            .topicIds(topicIds)
    }
}