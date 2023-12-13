package com.likeminds.internalsdk.widgets.model

import com.google.gson.annotations.SerializedName

class _WidgetMetaData_ private constructor(
    @SerializedName("body")
    val body: String?,
    @SerializedName("cover_image_url")
    val coverImageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("size")
    val size: Long?,
    @SerializedName("url")
    val url: String?
) {
    class Builder {
        private var body: String? = null
        private var coverImageUrl: String? = null
        private var title: String? = null
        private var name: String? = null
        private var size: Long? = null
        private var url: String? = null

        fun body(body: String?) = apply { this.body = body }
        fun coverImageUrl(coverImageUrl: String?) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String?) = apply { this.title = title }
        fun name(name: String?) = apply { this.name = name }
        fun size(size: Long?) = apply { this.size = size }
        fun url(url: String?) = apply { this.url = url }

        fun build() = _WidgetMetaData_(
            body,
            coverImageUrl,
            title,
            name,
            size,
            url
        )
    }

    fun toBuilder(): Builder {
        return Builder().body(body)
            .coverImageUrl(coverImageUrl)
            .title(title)
            .name(name)
            .size(size)
            .url(url)
    }
}