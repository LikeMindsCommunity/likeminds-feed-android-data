package com.likeminds.likemindsfeed.configuration.util

import com.likeminds.likemindsfeed.configuration.model.ConfigurationType

object ConfigurationUtil {
    /**
     * Get the enum of [ConfigurationType] using String value of type
     */
    fun String.getConfigurationType(): ConfigurationType {
        return when (this) {
            ConfigurationType.NONE.value -> ConfigurationType.NONE
            ConfigurationType.MEDIA_LIMITS.value -> ConfigurationType.MEDIA_LIMITS
            ConfigurationType.FEED_METADATA.value -> ConfigurationType.FEED_METADATA
            ConfigurationType.PROFILE_METADATA.value -> ConfigurationType.PROFILE_METADATA
            else -> ConfigurationType.NONE
        }
    }
}