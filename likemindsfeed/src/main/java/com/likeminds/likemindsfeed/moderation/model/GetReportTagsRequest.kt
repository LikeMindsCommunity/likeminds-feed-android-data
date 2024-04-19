package com.likeminds.likemindsfeed.moderation.model

class GetReportTagsRequest private constructor(
    val type: Int
) {

    class Builder {
        private var type: Int = -1

        fun type(type: Int) = apply { this.type = type }

        fun build() = GetReportTagsRequest(type)
    }

    fun toBuilder(): Builder {
        return Builder().type(type)
    }
}