package com.likeminds.internalsdk

interface LMInternalCallback {
    fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String)

    fun onRefreshTokenExpired(): Pair<String?, String?>
}