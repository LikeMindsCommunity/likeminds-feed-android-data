package com.likeminds.likemindsfeed.initiateUser.model

class LogoutRequest private constructor(
    var refreshToken: String
) {

    class Builder {
        private var refreshToken: String = ""

        fun refreshToken(refreshToken: String) = apply { this.refreshToken = refreshToken }

        fun build() = LogoutRequest(refreshToken)
    }

    fun toBuilder(): Builder {
        return Builder().refreshToken(refreshToken)
    }
}