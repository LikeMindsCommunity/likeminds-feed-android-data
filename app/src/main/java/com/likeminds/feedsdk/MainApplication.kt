package com.likeminds.feedsdk

import android.app.Application
import android.util.Log
import com.likeminds.likemindsfeed.LMFeedSDKCallback
import com.likeminds.likemindsfeed.LMFeedClient

class MainApplication : Application(), LMFeedSDKCallback {

    override fun onCreate() {
        super.onCreate()

        LMFeedClient.Builder(this)
            .lmCallback(this)
            .build()
    }

    override fun login() {
        Log.d("TAG---", "login: ")
    }
}