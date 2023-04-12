package com.likeminds.feedsdk

import android.app.Application
import android.util.Log
import com.likeminds.likemindsfeed.LMCallback
import com.likeminds.likemindsfeed.LMFeedClient

class MainApplication : Application(), LMCallback {

    override fun onCreate() {
        super.onCreate()

        val client = LMFeedClient.Builder(this)
            .lmCallback(this)
            .build()
    }

    override fun login() {
        Log.d("TAG---", "login: ")
    }
}