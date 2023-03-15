package com.likeminds.internalsdk.sdk

import android.app.Application
import com.likeminds.internalsdk.utils.sharedpreferences.BasePreferences
import javax.inject.Inject

class SDKPreferences @Inject constructor(
    application: Application
) : BasePreferences(SDK_PREFS, application) {
    companion object {
        const val SDK_PREFS = "sdk_prefs"
    }
}