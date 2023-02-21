package com.likeminds.likemindsfeed.initiateUser.model

class InitiateUserRequest private constructor(
    var userName: String?,
    var userId: String?,
    var isGuest: Boolean?
) {
    class Builder {
        private var userName: String? = null
        private var userId: String? = null
        private var isGuest: Boolean? = null

        fun userName(userName: String?) = apply { this.userName = userName }
        fun userId(userId: String?) = apply { this.userId = userId }
        fun isGuest(isGuest: Boolean?) = apply { this.isGuest = isGuest }

        fun build() = InitiateUserRequest(
            userName,
            userId,
            isGuest
        )
    }

    fun toBuilder(): Builder {
        return Builder()
    }
}