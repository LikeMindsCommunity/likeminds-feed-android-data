package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

//TODO: check for width and height
data class AttachmentMeta(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("size")
    val size: Long? = null,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("page_count")
    val pageCount: Int? = null,
    @SerializedName("og_tags")
    val ogTags: LinkOGTags,
    val awsFolderPath: String? = null,
    val localFilePath: String? = null,
    val index: Int? = null,
    val width: Int? = null,
    val height: Int? = null
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
