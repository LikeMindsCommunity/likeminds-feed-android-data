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
        private const val NOTIFICATION_ICON = "NOTIFICATION_ICON"
    }

    fun setAPIKey(apiKey: String) {
        putPreference(API_KEY, apiKey)
    }

    fun getAPIKey(): String {
        return getPreference(API_KEY, "") ?: ""
    }

    fun setNotificationIcon(notificationIcon: Int) {
        putPreference(NOTIFICATION_ICON, notificationIcon)
    }

    fun getNotificationIcon(): Int {
        return getPreference(NOTIFICATION_ICON, 0)
    }
}