package com.likeminds.likemindsfeed.configuration.model

class GetCommunityConfigurationRequest private constructor(
    val type: ConfigurationType
) {

    class Builder {
        private var type: ConfigurationType = ConfigurationType.NONE

        fun type(type: ConfigurationType) = apply {
            this.type = type
        }

        fun build() = GetCommunityConfigurationRequest(
            type
        )
    }

    fun toBuilder(): Builder {
        return Builder().type(type)
    }
}