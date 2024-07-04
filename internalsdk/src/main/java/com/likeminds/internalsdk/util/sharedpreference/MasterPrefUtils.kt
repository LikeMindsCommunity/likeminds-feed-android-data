package com.likeminds.internalsdk.util.sharedpreference

import android.content.Context
import android.content.SharedPreferences

object MasterPrefUtils {
    fun clearAllPrefs(context: Context) {
        val masterPref: SharedPreferences =
            context.getSharedPreferences(
                BasePreferences.MASTER_PREF,
                Context.MODE_PRIVATE
            )
        val listOfPreferences =
            masterPref.getStringSet(BasePreferences.ALL_PREFS_SET, null)
                ?.toMutableList()
        if (!listOfPreferences.isNullOrEmpty()) {
            for (i in listOfPreferences.indices) {
                // clear each preference file
                context.getSharedPreferences(listOfPreferences[i], Context.MODE_PRIVATE)
                    .edit().clear().apply()
            }
        }
    }
}