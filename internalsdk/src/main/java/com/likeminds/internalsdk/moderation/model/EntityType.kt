package com.likeminds.internalsdk.moderation.model

import androidx.annotation.IntDef

const val POST = 5
const val COMMENT = 6
const val REPLY = 7

@IntDef(
    POST,
    COMMENT,
    REPLY
)
@Retention(AnnotationRetention.SOURCE)
annotation class EntityType