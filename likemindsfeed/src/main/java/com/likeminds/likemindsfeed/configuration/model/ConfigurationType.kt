package com.likeminds.likemindsfeed.configuration.model

enum class ConfigurationType(val value: String) {
    NONE("none"),
    MEDIA_LIMITS("media_limits"),
    FEED_METADATA("feed_metadata"),
    PROFILE_METADATA("profile_metadata"),
    NSFW_FILTERING("nsfw_filtering"),
    WIDGETS_METADATA("widgets_metadata"),
    GUEST_FLOW_METADATA("guest_flow_metadata"),
    FEED_SETTINGS("feed_settings"),
    PERSONALISED_FEED_WEIGHTS("personalised_feed_weights"),
    CHATBOT("chatbot"),
    CHAT_POLL("chat_poll")
}