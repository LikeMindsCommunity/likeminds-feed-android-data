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
    val ogTags: _LinkOGTags_
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: _LinkOGTags_ = _LinkOGTags_.Builder().build()

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: _LinkOGTags_) = apply { this.ogTags = ogTags }

        fun build() = _AttachmentMeta_(
            name,
            url,
            format,
            size,
            duration,
            pageCount,
            ogTags
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
    }
}
