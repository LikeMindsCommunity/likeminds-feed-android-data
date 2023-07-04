package com.likeminds.likemindsfeed.initiateUser.model

class InitiateUserRequest private constructor(
    val apiKey: String,
    val deviceId: String,
    val userName: String,
    val uuid: String?,
    val isGuest: Boolean?
) {
    class Builder {
        private var apiKey: String = ""
        private var deviceId: String = ""
        private var userName: String = ""
        private var uuid: String? = null
        private var isGuest: Boolean? = null

        fun apiKey(apiKey: String) = apply { this.apiKey = apiKey }
        fun deviceId(deviceId: String) = apply { this.deviceId = deviceId }
        fun userName(userName: String) = apply { this.userName = userName }
        fun uuid(uuid: String?) = apply { this.uuid = uuid }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }

        fun build() = InitiateUserRequest(
            apiKey,
            deviceId,
            userName,
            uuid,
            isGuest
        )
    }

    fun toBuilder(): Builder {
        return Builder().uuid(uuid)
            .apiKey(apiKey)
            .deviceId(deviceId)
            .isGuest(isGuest)
            .userName(userName)
    }
}