package com.likeminds.internalsdk.widgets.model

import com.google.gson.annotations.SerializedName

class _MetaData_ private constructor(
    @SerializedName("body")
    val body: String,
    @SerializedName("cover_image_url")
    val coverImageUrl: String,
    @SerializedName("title")
    val title: String
) {
    class Builder {
        private var body: String = ""
        private var coverImageUrl: String = ""
        private var title: String = ""

        fun body(body: String) = apply { this.body = body }
        fun coverImageUrl(coverImageUrl: String) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String) = apply { this.title = title }

        fun build() = _MetaData_(
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