package com.likeminds.likemindsfeed.post.model

class AttachmentMeta private constructor(
    val name: String?,
    val url: String?,
    val format: String?,
    val size: Long?,
    val duration: Int?,
    val pageCount: Int?,
    val ogTags: LinkOGTags
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: LinkOGTags = LinkOGTags.Builder().build()

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: LinkOGTags) = apply { this.ogTags = ogTags }

        fun build() = AttachmentMeta(
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
