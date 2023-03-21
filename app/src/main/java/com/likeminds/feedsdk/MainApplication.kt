package com.likeminds.feedsdk

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val client = LMFeedClient.Builder(this).build()
    }
}