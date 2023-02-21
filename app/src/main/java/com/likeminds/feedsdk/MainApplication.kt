package com.likeminds.feedsdk

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val extra = InitiateLikeMindsExtra.Builder().apiKey("6a4cc38e-02c7-4dfa-96b7-68a3078ad922")
            .application(this).build()

        val client = LMFeedClient.build(extra)
    }
}