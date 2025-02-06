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
            ConfigurationType.NSFW_FILTERING.value -> ConfigurationType.NSFW_FILTERING
            ConfigurationType.WIDGETS_METADATA.value -> ConfigurationType.WIDGETS_METADATA
            ConfigurationType.GUEST_FLOW_METADATA.value -> ConfigurationType.GUEST_FLOW_METADATA
            ConfigurationType.FEED_SETTINGS.value -> ConfigurationType.FEED_SETTINGS
            ConfigurationType.PERSONALISED_FEED_WEIGHTS.value -> ConfigurationType.PERSONALISED_FEED_WEIGHTS
            ConfigurationType.CHATBOT.value -> ConfigurationType.CHATBOT
            ConfigurationType.CHAT_POLL.value -> ConfigurationType.CHAT_POLL
            else -> ConfigurationType.NONE
        }
    }
}