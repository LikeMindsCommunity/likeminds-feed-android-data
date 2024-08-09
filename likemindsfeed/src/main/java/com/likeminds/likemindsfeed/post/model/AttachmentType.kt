package com.likeminds.likemindsfeed.post.model

enum class AttachmentType(val value: Int) {
    NONE(0),
    IMAGE(1),
    VIDEO(2),
    DOCUMENT(3),
    LINK(4),
    CUSTOM_WIDGET(5),
    POLL(6),
    REEL(11)
}