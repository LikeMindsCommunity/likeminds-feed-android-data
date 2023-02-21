package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

data class MenuItem(
    @SerializedName("title")
    var title: String
)