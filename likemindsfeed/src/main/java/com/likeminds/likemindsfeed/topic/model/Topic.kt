package com.likeminds.likemindsfeed.topic.model

class Topic private constructor(
    val id: String,
    val isEnabled: Boolean,
    val name: String
) {
    class Builder {
        private var id: String = ""
        private var isEnabled: Boolean = false
        private var name: String = ""


        fun id(id: String) = apply { this.id = id }
        fun isEnabled(isEnabled: Boolean) = apply { this.isEnabled = isEnabled }
        fun name(name: String) = apply { this.name = name }

        fun build() = Topic(id, isEnabled, name)
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .isEnabled(isEnabled)
            .name(name)
    }

    override fun toString(): String {
        return buildString {
            append("Topic(id='")
            append(id)
            append("', isEnabled=")
            append(isEnabled)
            append(", name='")
            append(name)
            append("')")
        }
    }
}