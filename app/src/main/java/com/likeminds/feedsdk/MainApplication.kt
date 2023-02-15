package com.likeminds.feedsdk

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val extra = InitiateLikeMindsExtra.Builder().apiKey("01c77c08-f703-483c-9b5c-fa823be2032f")
            .application(this).build()

        val client = LMFeedClient.build(extra)
    }
}