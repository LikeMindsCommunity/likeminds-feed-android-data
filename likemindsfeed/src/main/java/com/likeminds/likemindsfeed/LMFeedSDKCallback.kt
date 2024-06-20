package com.likeminds.likemindsfeed

import androidx.annotation.Keep

@Keep
interface LMFeedSDKCallback {
    fun login() {}

    fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String) {}

    fun onRefreshTokenExpired(): Pair<String?, String?> {
        return Pair(null, null)
    }
}