package com.likeminds.internalsdk.topic.model

import com.google.gson.annotations.SerializedName

class _Topic_ private constructor(
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    @SerializedName("name")
    val name: String
) {
    class Builder {
        private var id: String = ""
        private var isEnabled: Boolean = false
        private var name: String = ""

        fun id(id: String) = apply { this.id = id }
        fun isEnabled(isEnabled: Boolean) = apply { this.isEnabled = isEnabled }
        fun name(name: String) = apply { this.name = name }

        fun build() = _Topic_(id, isEnabled, name)
    }

    fun toBuilder():Builder{
        return Builder().id(id)
            .isEnabled(isEnabled)
            .name(name)
    }
}