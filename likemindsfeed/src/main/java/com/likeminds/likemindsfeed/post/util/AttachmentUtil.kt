package com.likeminds.likemindsfeed.post.util

import com.likeminds.likemindsfeed.post.model.AttachmentType

object AttachmentUtil {

    /***
     * Get the enum of [AttachmentType] using Int value of the attachment type
     * @param [Int]
     * @return [AttachmentType]
     */
    fun Int.getAttachmentType(): AttachmentType {
        return when (this) {
            AttachmentType.IMAGE.value -> AttachmentType.IMAGE
            AttachmentType.VIDEO.value -> AttachmentType.VIDEO
            AttachmentType.DOCUMENT.value -> AttachmentType.DOCUMENT
            AttachmentType.LINK.value -> AttachmentType.LINK
            AttachmentType.CUSTOM_WIDGET.value -> AttachmentType.CUSTOM_WIDGET
            AttachmentType.POLL.value -> AttachmentType.POLL
            AttachmentType.ARTICLE.value -> AttachmentType.ARTICLE
            AttachmentType.REEL.value -> AttachmentType.REEL
            else -> AttachmentType.NONE
        }
    }

    /***
     * Get the enum of [AttachmentType] using Int value of the attachment type
     * @param [Int]
     * @return [AttachmentType]
     */
    fun AttachmentType.getAttachmentValue(): Int {
        return when (this) {
            AttachmentType.NONE -> AttachmentType.NONE.value
            AttachmentType.IMAGE -> AttachmentType.IMAGE.value
            AttachmentType.VIDEO -> AttachmentType.VIDEO.value
            AttachmentType.DOCUMENT -> AttachmentType.DOCUMENT.value
            AttachmentType.LINK -> AttachmentType.LINK.value
            AttachmentType.CUSTOM_WIDGET -> AttachmentType.CUSTOM_WIDGET.value
            AttachmentType.POLL -> AttachmentType.POLL.value
            AttachmentType.ARTICLE -> AttachmentType.ARTICLE.value
            AttachmentType.REEL -> AttachmentType.REEL.value
        }
    }
}