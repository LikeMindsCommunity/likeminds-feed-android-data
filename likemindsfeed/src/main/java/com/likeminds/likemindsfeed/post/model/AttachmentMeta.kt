package com.likeminds.likemindsfeed.post.model

class AttachmentMeta private constructor(
    var name: String?,
    var url: String?,
    var format: String?,
    var size: Long?,
    var duration: Int?,
    var pageCount: Int?,
    var ogTags: LinkOGTags,
    var localFilePath: String?,
    var width: Int?,
    var height: Int?
) {

    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: LinkOGTags = LinkOGTags.Builder().build()
        private var localFilePath: String? = null
        private var width: Int? = null
        private var height: Int? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: LinkOGTags) = apply { this.ogTags = ogTags }
        fun localFilePath(localFilePath: String?) = apply { this.localFilePath = localFilePath }
        fun width(width: Int?) = apply { this.width = width }
        fun height(height: Int?) = apply { this.height = height }

        fun build() = AttachmentMeta(
            name,
            url,
            format,
            size,
            duration,
            pageCount,
            ogTags,
            localFilePath,
            width,
            height
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
            .localFilePath(localFilePath)
            .width(width)
            .height(height)
    }
}
