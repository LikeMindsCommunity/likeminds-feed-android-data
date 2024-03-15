package com.likeminds.likemindsfeed.post.model

import android.net.Uri

class AttachmentMeta private constructor(
    val name: String?,
    val url: String?,
    val format: String?,
    val size: Long?,
    val duration: Int?,
    val pageCount: Int?,
    val ogTags: LinkOGTags,
    val coverImageUrl: String?,
    val title: String?,
    val body: String?,
    val entityId: String?,
    val thumbnailUrl: String?,
    val awsFolderPath: String?,
    val localFilePath: String?,
    val localUri: Uri?,
    val thumbnailAWSFolderPath: String?,
    val thumbnailLocalFilePath: String?,
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: LinkOGTags = LinkOGTags.Builder().build()
        private var coverImageUrl: String? = null
        private var title: String? = null
        private var body: String? = null
        private var entityId: String? = null
        private var thumbnailUrl: String? = null
        private var awsFolderPath: String? = null
        private var localFilePath: String? = null
        private var localUri: Uri? = null
        private var thumbnailAWSFolderPath: String? = null
        private var thumbnailLocalFilePath: String? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: LinkOGTags) = apply { this.ogTags = ogTags }
        fun coverImageUrl(coverImageUrl: String?) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String?) = apply { this.title = title }
        fun body(body: String?) = apply { this.body = body }
        fun entityId(entityId: String?) = apply { this.entityId = entityId }
        fun thumbnailUrl(thumbnailUrl: String?) = apply { this.thumbnailUrl = thumbnailUrl }
        fun awsFolderPath(awsFolderPath: String?) = apply { this.awsFolderPath = awsFolderPath }
        fun localFilePath(localFilePath: String?) = apply { this.localFilePath = localFilePath }
        fun localUri(localUri: Uri?) = apply { this.localUri = localUri }
        fun thumbnailAWSFolderPath(thumbnailAWSFolderPath: String?) =
            apply { this.thumbnailAWSFolderPath = thumbnailAWSFolderPath }

        fun thumbnailLocalFilePath(thumbnailLocalFilePath: String?) =
            apply { this.thumbnailLocalFilePath = thumbnailLocalFilePath }

        fun build() = AttachmentMeta(
            name,
            url,
            format,
            size,
            duration,
            pageCount,
            ogTags,
            coverImageUrl,
            title,
            body,
            entityId,
            thumbnailUrl,
            awsFolderPath,
            localFilePath,
            localUri,
            thumbnailAWSFolderPath,
            thumbnailLocalFilePath
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
            .entityId(entityId)
            .thumbnailUrl(thumbnailUrl)
            .awsFolderPath(awsFolderPath)
            .localFilePath(localFilePath)
            .localUri(localUri)
    }
}
