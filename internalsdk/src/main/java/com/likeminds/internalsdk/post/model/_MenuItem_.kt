package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _MenuItem_ private constructor(
    @SerializedName("title")
    var title: String
) {

    class Builder {

        private var title: String = ""

        fun title(title: String) = apply { this.title = title }
    }

    fun toBuilder(): Builder {
        return Builder().title(title)
    }
}