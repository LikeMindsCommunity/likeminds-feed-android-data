package com.likeminds.internalsdk

import javax.inject.Singleton

@Singleton
class TokenManager private constructor() {
    var accessToken: String? = null
    var refreshToken: String? = null
    var memberId: String? = null

    companion object {
        @JvmStatic
        private var tokenManagerInstance: TokenManager? = null

        fun getInstance(): TokenManager {
            if (tokenManagerInstance == null) {
                tokenManagerInstance = TokenManager()
            }

            return tokenManagerInstance!!
        }
    }

    fun updateTokens(
        accessToken: String? = null,
        refreshToken: String? = null,
        memberId: String? = null
    ) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
        this.memberId = memberId
    }

}