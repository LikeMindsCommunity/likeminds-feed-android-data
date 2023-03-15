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

    // stores api key in SharedPreferences
    fun setAPIKey(apiKey: String) {
        putPreference(API_KEY, apiKey)
    }

    /**
     * @return api key from SharedPreferences
     */
    fun getAPIKey(): String {
        return getPreference(API_KEY, "") ?: ""
    }

    // stores notification icon in SharedPreferences
    fun setNotificationIcon(notificationIcon: Int) {
        putPreference(NOTIFICATION_ICON, notificationIcon)
    }

    /**
     * @return api key from SharedPreferences
     */
    fun getNotificationIcon(): Int {
        return getPreference(NOTIFICATION_ICON, 0)
    }
}