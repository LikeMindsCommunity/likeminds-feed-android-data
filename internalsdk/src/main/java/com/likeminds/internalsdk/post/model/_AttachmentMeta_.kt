package com.likeminds.internalsdk.post.model

import com.google.gson.JsonObject
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
    val ogTags: _LinkOGTags_?,
    @SerializedName("cover_image_url")
    val coverImageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("entity_id")
    val entityId: String?,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String?,

    //poll related
    @SerializedName("expiry_time")
    val expiryTime: Long?,
    @SerializedName("options")
    val pollOptions: List<String>?,
    @SerializedName("multiple_select_state")
    val multiSelectState: String?,
    @SerializedName("poll_type")
    val pollType: String?,
    @SerializedName("multiple_select_number")
    val multiSelectNumber: Int?,
    @SerializedName("is_anonymous")
    val isAnonymous: Boolean?,
    @SerializedName("allow_add_option")
    val allowAddOption: Boolean?,

    //for custom widget
    @SerializedName("meta")
    val meta: JsonObject?
) {
    class Builder {

        private var name: String? = null
        private var url: String? = null
        private var format: String? = null
        private var size: Long? = null
        private var duration: Int? = null
        private var pageCount: Int? = null
        private var ogTags: _LinkOGTags_? = null
        private var coverImageUrl: String? = null
        private var title: String? = null
        private var body: String? = null
        private var entityId: String? = null
        private var thumbnailUrl: String? = null
        private var expiryTime: Long? = null
        private var pollOptions: List<String>? = null
        private var multiSelectState: String? = null
        private var pollType: String? = null
        private var multiSelectNumber: Int? = null
        private var isAnonymous: Boolean? = null
        private var allowAddOption: Boolean? = null
        private var meta: JsonObject? = null

        fun name(name: String?) = apply { this.name = name }
        fun url(url: String?) = apply { this.url = url }
        fun format(format: String?) = apply { this.format = format }
        fun size(size: Long?) = apply { this.size = size }
        fun duration(duration: Int?) = apply { this.duration = duration }
        fun pageCount(pageCount: Int?) = apply { this.pageCount = pageCount }
        fun ogTags(ogTags: _LinkOGTags_?) = apply { this.ogTags = ogTags }
        fun coverImageUrl(coverImageUrl: String?) = apply { this.coverImageUrl = coverImageUrl }
        fun title(title: String?) = apply { this.title = title }
        fun body(body: String?) = apply { this.body = body }
        fun entityId(entityId: String?) = apply { this.entityId = entityId }
        fun thumbnailUrl(thumbnailUrl: String?) = apply { this.thumbnailUrl = thumbnailUrl }
        fun expiryTime(expiryTime: Long?) = apply { this.expiryTime = expiryTime }
        fun pollOptions(pollOptions: List<String>?) = apply { this.pollOptions = pollOptions }
        fun multiSelectState(multiSelectState: String?) =
            apply { this.multiSelectState = multiSelectState }

        fun pollType(pollType: String?) = apply { this.pollType = pollType }
        fun multiSelectNumber(multiSelectNo: Int?) =
            apply { this.multiSelectNumber = multiSelectNo }

        fun isAnonymous(isAnonymous: Boolean?) = apply { this.isAnonymous = isAnonymous }
        fun allowAddOption(allowAddOption: Boolean?) =
            apply { this.allowAddOption = allowAddOption }

        fun meta(meta: JsonObject?) = apply { this.meta = meta }

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
            body,
            entityId,
            thumbnailUrl,
            expiryTime,
            pollOptions,
            multiSelectState,
            pollType,
            multiSelectNumber,
            isAnonymous,
            allowAddOption,
            meta
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
            .expiryTime(expiryTime)
            .pollOptions(pollOptions)
            .multiSelectState(multiSelectState)
            .pollType(pollType)
            .multiSelectNumber(multiSelectNumber)
            .isAnonymous(isAnonymous)
            .allowAddOption(allowAddOption)
            .meta(meta)
    }
}
