package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

//TODO: check for width and height
class _AttachmentMeta_ private constructor(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("format")
    var format: String?,
    @SerializedName("size")
    var size: Long?,
    @SerializedName("duration")
    var duration: Int?,
    @SerializedName("page_count")
    var pageCount: Int?,
    @SerializedName("og_tags")
    var ogTags: _LinkOGTags_,
    var awsFolderPath: String?,
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
        private var ogTags: _LinkOGTags_ = _LinkOGTags_.Builder().build()
        private var awsFolderPath: String? = null
        private var localFilePath: String? = null
        private var width: Int? = null
        private var height: Int? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: _LinkOGTags_) = apply { this.ogTags = ogTags }
        fun awsFolderPath(awsFolderPath: String?) = apply { this.awsFolderPath = awsFolderPath }
        fun localFilePath(localFilePath: String?) = apply { this.localFilePath = localFilePath }
        fun width(width: Int?) = apply { this.width = width }
        fun height(height: Int?) = apply { this.height = height }

        fun build() = _AttachmentMeta_(
            name,
            url,
            format,
            size,
            duration,
            pageCount,
            ogTags,
            awsFolderPath,
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
            .awsFolderPath(awsFolderPath)
            .localFilePath(localFilePath)
            .width(width)
            .height(height)
    }
}
