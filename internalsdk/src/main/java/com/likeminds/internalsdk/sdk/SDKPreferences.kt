package com.likeminds.internalsdk.sdk

import android.app.Application
import com.likeminds.internalsdk.utils.sharedpreferences.BasePreferences
import javax.inject.Inject

class SDKPreferences @Inject constructor(
    application: Application
) : BasePreferences(SDK_PREFS, application) {
    companion object {
        const val SDK_PREFS = "sdk_prefs"

        private const val API_KEY = "API_KEY"
        private const val DOMAIN = "DOMAIN"
        private const val NOTIFICATION_ICON = "NOTIFICATION_ICON"
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        private const val REFRESH_TOKEN = "REFRESH_TOKEN"
        private const val ACCESS_TOKEN_TIMESTAMP = "ACCESS_TOKEN_TIMESTAMP"
    }

    fun setAPIKey(apiKey: String) {
        putPreference(API_KEY, apiKey)
    }

    fun getAPIKey(): String {
        return getPreference(API_KEY, "") ?: ""
    }

    fun setAccessToken(accessToken: String) {
        putPreference(ACCESS_TOKEN, accessToken)
    }

    fun setAccessTokenTimeStamp(timestamp: Long) {
        putPreference(ACCESS_TOKEN_TIMESTAMP, timestamp)
    }

    fun setRefreshToken(refreshToken: String) {
        putPreference(REFRESH_TOKEN, refreshToken)
    }

    fun getRefreshToken(): String {
        return getPreference(REFRESH_TOKEN, "") ?: ""
    }

    fun setNotificationIcon(notificationIcon: Int) {
        putPreference(NOTIFICATION_ICON, notificationIcon)
    }

    fun getNotificationIcon(): Int {
        return getPreference(NOTIFICATION_ICON, 0)
    }

    fun setDomain(domain: String?) {
        if (domain == null) return
        putPreference(DOMAIN, domain)
    }

    fun getDomain(): String? {
        return getPreference(DOMAIN, "")
    }
}