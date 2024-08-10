package com.likeminds.likemindsfeed.post.model

import android.net.Uri
import org.json.JSONObject

class AttachmentMeta private constructor(
    val name: String?,
    val url: String?,
    val format: String?,
    val size: Long?,
    val duration: Int?,
    val pageCount: Int?,
    val ogTags: LinkOGTags?,
    val coverImageUrl: String?,
    val title: String?,
    val body: String?,
    val entityId: String?,

    //upload related
    val thumbnailUrl: String?,
    val awsFolderPath: String?,
    val localFilePath: String?,
    val localUri: Uri?,
    val thumbnailAWSFolderPath: String?,
    val thumbnailLocalFilePath: String?,
    //poll related
    val expiryTime: Long?,
    val pollOptions: List<String>?,
    val multiSelectState: PollMultiSelectState?,
    val pollType: PollType?,
    val multiSelectNumber: Int?,
    val isAnonymous: Boolean?,
    val allowAddOption: Boolean?,
    //custom widget related
    val meta: JSONObject?,
    val height: Int?,
    val width: Int?
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: LinkOGTags? = null
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
        private var expiryTime: Long? = null
        private var pollOptions: List<String>? = null
        private var multiSelectState: PollMultiSelectState? = null
        private var pollType: PollType? = null
        private var multiSelectNumber: Int? = null
        private var isAnonymous: Boolean? = null
        private var allowAddOption: Boolean? = null
        private var meta: JSONObject? = null
        private var height: Int? = null
        private var width: Int? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: LinkOGTags?) = apply { this.ogTags = ogTags }
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

        fun expiryTime(expiryTime: Long?) = apply { this.expiryTime = expiryTime }
        fun pollOptions(pollOptions: List<String>?) = apply { this.pollOptions = pollOptions }
        fun multiSelectState(multiSelectState: PollMultiSelectState?) =
            apply { this.multiSelectState = multiSelectState }

        fun pollType(pollType: PollType?) = apply { this.pollType = pollType }
        fun multiSelectNumber(multiSelectNo: Int?) =
            apply { this.multiSelectNumber = multiSelectNo }

        fun isAnonymous(isAnonymous: Boolean?) = apply { this.isAnonymous = isAnonymous }
        fun allowAddOption(allowAddOption: Boolean?) =
            apply { this.allowAddOption = allowAddOption }

        fun meta(meta: JSONObject?) = apply { this.meta = meta }
        fun height(height: Int?) = apply { this.height = height }
        fun width(width: Int?) = apply { this.width = width }

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
            thumbnailLocalFilePath,
            expiryTime,
            pollOptions,
            multiSelectState,
            pollType,
            multiSelectNumber,
            isAnonymous,
            allowAddOption,
            meta,
            height,
            width
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
            .thumbnailAWSFolderPath(thumbnailAWSFolderPath)
            .thumbnailLocalFilePath(thumbnailLocalFilePath)
            .expiryTime(expiryTime)
            .pollOptions(pollOptions)
            .multiSelectState(multiSelectState)
            .pollType(pollType)
            .multiSelectNumber(multiSelectNumber)
            .isAnonymous(isAnonymous)
            .allowAddOption(allowAddOption)
            .meta(meta)
            .height(height)
            .width(width)
    }

    override fun toString(): String {
        return buildString {
            append("AttachmentMeta(name=")
            append(name)
            append(", url=")
            append(url)
            append(", format=")
            append(format)
            append(", size=")
            append(size)
            append(", duration=")
            append(duration)
            append(", pageCount=")
            append(pageCount)
            append(", ogTags=")
            append(ogTags)
            append(", coverImageUrl=")
            append(coverImageUrl)
            append(", title=")
            append(title)
            append(", body=")
            append(body)
            append(", entityId=")
            append(entityId)
            append(",")
            append("thumbnailUrl=")
            append(thumbnailUrl)
            append(", awsFolderPath=")
            append(awsFolderPath)
            append(", localFilePath=")
            append(localFilePath)
            append(", localUri=")
            append(localUri)
            append(", thumbnailAWSFolderPath=")
            append(thumbnailAWSFolderPath)
            append(", thumbnailLocalFilePath=")
            append(thumbnailLocalFilePath)
            append(", expiryTime=")
            append(expiryTime)
            append(", pollOptions=")
            append(pollOptions)
            append(", multiSelectState=")
            append(multiSelectState)
            append(", pollType=")
            append(pollType)
            append(", multiSelectNumber=")
            append(multiSelectNumber)
            append(", isAnonymous=")
            append(isAnonymous)
            append(", allowAddOption=")
            append(allowAddOption)
            append(", meta=")
            append(meta)
            append(", height=")
            append(height)
            append(", width=")
            append(width)
            append(")")
        }
    }
}
