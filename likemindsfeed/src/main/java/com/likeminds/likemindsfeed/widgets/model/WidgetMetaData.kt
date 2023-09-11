package com.likeminds.likemindsfeed.widgets.model

class WidgetMetaData private constructor(
    val body: String,
    val coverImageUrl: String,
    val title: String
) {
    class Builder {
        private var body: String = ""
        private var coverImageUrl: String = ""
        private var title: String = ""

        fun body(body: String) = apply { this.body = body }
        fun coverImageUrl(coverImageUrl: String) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String) = apply { this.title = title }

        fun build() = WidgetMetaData(
            body,
            coverImageUrl,
            title
        )
    }

    fun toBuilder(): Builder {
        return Builder().body(body)
            .coverImageUrl(coverImageUrl)
            .title(title)
    }
}