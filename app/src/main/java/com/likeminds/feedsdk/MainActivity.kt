package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
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
                    .apiKey("5f567ca1-9d74-4a1b-be8b-a7a81fef796f")
                    .uuid("89ef3318-ce0e-4d22-9da8-ed9f06bf3538")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "initiateResponse: ${initiateResponse.data?.user?.sdkClientInfo?.uuid}")

            val getFeedRequest = GetFeedRequest.Builder()
                .page(1)
                .pageSize(10)
                .topicIds(listOf("65096a5c74980f360624b8a6", "65096a8a74980f360624b8a7"))
                .build()

            val feedResponse = client.getFeed(getFeedRequest)

            Log.d(
                "PUI", """
                feedResponse: ${feedResponse.data?.posts?.size}
            """.trimIndent()
            )
        }
    }
}