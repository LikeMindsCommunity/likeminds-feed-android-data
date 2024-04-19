package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "test_feed_data"
    }

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = LMFeedClient.getInstance()
        CoroutineScope(Dispatchers.IO).launch {
            val initiateResponse = client.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("69edd43f-4a5e-4077-9c50-2b7aa740acce")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )
        }
    }
}