package com.likeminds.likemindsfeed

import androidx.annotation.Keep

@Keep
interface LMFeedSDKCallback {
    fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String)

    fun onRefreshTokenExpired(): Pair<String?, String?>
}