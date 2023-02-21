package com.likeminds.internalsdk.post.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class _AttachmentMeta_(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("format")
    val format: String?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("page_count")
    val pageCount: Int?,
    @SerializedName("og_tags")
    val ogTags: _LinkOGTags_,
)

data class _LinkOGTags_(
    @SerializedName("title")
    val title: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
)
