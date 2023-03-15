package com.likeminds.internalsdk.post.model

import com.google.gson.annotations.SerializedName

class _DeletePostRequest_ private constructor(
    @SerializedName("delete_reason")
    var deleteReason: String?,
) {

    class Builder {
        private var deleteReason: String? = ""

        fun deleteReason(deleteReason: String?) = apply { this.deleteReason = deleteReason }

        fun build() = _DeletePostRequest_(deleteReason)
    }

    fun toBuilder(): Builder {
        return Builder().deleteReason(deleteReason)
    }
}