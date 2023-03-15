package com.likeminds.likemindsfeed.initiateUser.model

class InitiateUserRequest private constructor(
    var apiKey: String,
    var userName: String?,
    var userId: String?,
    var isGuest: Boolean?
) {
    class Builder {
        private var apiKey: String = ""
        private var userName: String? = null
        private var userId: String? = null
        private var isGuest: Boolean? = null

        fun apiKey(apiKey: String) = apply { this.apiKey = apiKey }
        fun userName(userName: String?) = apply { this.userName = userName }
        fun userId(userId: String?) = apply { this.userId = userId }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }

        fun build() = InitiateUserRequest(
            apiKey,
            userName,
            userId,
            isGuest
        )
    }

    fun toBuilder(): Builder {
        return Builder().userId(userId)
            .apiKey(apiKey)
            .isGuest(isGuest)
            .userName(userName)
    }
}