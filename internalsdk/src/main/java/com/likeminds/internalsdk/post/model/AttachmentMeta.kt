package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class AttachmentMeta(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("page_count")
    val pageCount: Int? = null,
    @SerializedName("og_tags")
    val ogTags: LinkOGTags,
)

data class LinkOGTags(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("url")
    val url: String? = null,
)
