package com.likeminds.likemindsfeed.configuration.model

import org.json.JSONObject

class Configuration private constructor(
    val type: String,
    val description: String,
    val value: JSONObject
) {
    class Builder {
        private var type: String = ""
        private var description: String = ""
        private var value: JSONObject = JSONObject()

        fun type(type: String) = apply { this.type = type }
        fun description(description: String) = apply { this.description = description }
        fun value(value: JSONObject) = apply { this.value = value }

        fun build() = Configuration(type, description, value)
    }

    fun toBuilder(): Builder {
        return Builder().type(type)
            .description(description)
            .value(value)
    }

    override fun toString(): String {
        return "Configuration recieved as type: $type description:$description value$value"
    }
}