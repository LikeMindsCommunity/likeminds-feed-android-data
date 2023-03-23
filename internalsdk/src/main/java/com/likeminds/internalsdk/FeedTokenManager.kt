package com.likeminds.internalsdk

import javax.inject.Singleton

@Singleton
class FeedTokenManager {
    var accessToken: String? = null
    var refreshToken: String? = null

    companion object {
        @JvmStatic
        private var feedTokenManagerInstance: FeedTokenManager? = null

        fun getInstance(): FeedTokenManager {
            if (feedTokenManagerInstance == null) {
                feedTokenManagerInstance = FeedTokenManager()
            }

            return feedTokenManagerInstance!!
        }
    }

    // updates tokens and memberId in TokenManager
    fun updateTokens(
        accessToken: String? = null,
        refreshToken: String? = null
    ) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
    }

    // clears existing tokens inside TokenManager
    fun clear() {
        accessToken = null
        refreshToken = null
    }
}