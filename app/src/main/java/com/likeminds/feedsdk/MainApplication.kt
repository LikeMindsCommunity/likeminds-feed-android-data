package com.likeminds.feedsdk

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val extra = InitiateLikeMindsExtra.Builder().application(this).build()

        val client = LMFeedClient.build(extra)
    }
}