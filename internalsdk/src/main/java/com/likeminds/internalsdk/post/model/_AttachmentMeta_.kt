package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _AttachmentMeta_ private constructor(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("format")
    val format: String?,
    @SerializedName("size")
    val size: Long?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("page_count")
    val pageCount: Int?,
    @SerializedName("og_tags")
    val ogTags: _LinkOGTags_,
    @SerializedName("cover_image_url")
    val coverImageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("body")
    val body: String?
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: _LinkOGTags_ = _LinkOGTags_.Builder().build()
        private var coverImageUrl: String? = null
        private var title: String? = null
        private var body: String? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: _LinkOGTags_) = apply { this.ogTags = ogTags }
        fun coverImageUrl(coverImageUrl: String?) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String?) = apply { this.title = title }
        fun body(body: String?) = apply { this.body = body }

        fun build() = _AttachmentMeta_(
            name,
            url,
            format,
            size,
            duration,
            pageCount,
            ogTags,
            coverImageUrl,
            title,
            body
        )
    }

    fun toBuilder(): Builder {
        return Builder().name(name)
            .url(url)
            .format(format)
            .size(size)
            .duration(duration)
            .pageCount(pageCount)
            .ogTags(ogTags)
            .coverImageUrl(coverImageUrl)
            .title(title)
            .body(body)
    }
}
