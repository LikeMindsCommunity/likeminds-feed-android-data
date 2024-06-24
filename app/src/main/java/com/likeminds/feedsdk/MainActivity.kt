package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
import com.likeminds.likemindsfeed.user.model.ValidateUserRequest
import kotlinx.coroutines.*

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
//            val initiateResponse = client.initiateUser(
//                InitiateUserRequest.Builder()
//                    .apiKey("4f881a74-8d0b-4c73-9f60-3d2370216392")
//                    .uuid("10003")
//                    .deviceId("adadad")
//                    .userName("Ishaan")
//                    .isGuest(false)
//                    .build()
//            )
//
            val accessToken =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiSVpLVURlcUNYU3QwSE4yRUI4UFNsU0VnVTNqczBPSGl3RTlLMTBXZkNoaDV3K0xpTk93SWsxWkJzdk5NN3IvRnV2WWhoTDBZZXRSSDV5QXozVjlXWG52RjVzbXlDemt2NDRxU0F5UUNUdjNYQ2FkWitrby94RzRLZkllTGx2RHUwUUdiSUYxTjZtVWFhRThVVUVxWWxjK1BKdTl3cUhUdTF1SWZSRitiRWJhU1ZZdUYxMlZreUlSMm14UnhNTUtZNG0xb0xDUFZLTFFqVmROUzNBbTZpMU9hcjhpUEhjQ2dCeW1OWUZqSEhoL2Y2Q254Ym9hR3M2ZHZHYzVhUlZLZEtoMVB6ZmRockdrcUx2SEkiLCJleHAiOjE3MTg5NjkyMzJ9.Cnk-WNIKLiAWvc9ooJ2M5puyLrQb_D9UawFsolGBTRE"
            val refreshToken =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiOEt5Z0N1cXMwQ3JVRUcrK2RLWnVWc3hneW5DMEE5M3haWGpsVmEvTzgrdUVCRGNyUjFpMGZzQXVaWkNaTVV4blg4QzMxeTlnd0dhdFl6eHhrWEwzZ2ZzbHM4QnduQTBIZUdUTjlrNjNGbFFiVXgrZGZIVDVEaVhJbDlxa2EybVFCSHZOVGlzSWNPaHVYRmplNlhESEFieE9wV2pkalVCWnBGTzBTTVlNNFdrQ21HYVovME5GdEtyamlMS3M4UEtzNCsyemczSnJvc0F1MzlFVEEzbm13RlJKSmhJWHNhT3llb0RjaVRqbGxxWEE1ZUZ6TTRJU05DaTBwUzdmakhsQ0orSUZrTUpUKzBudU40U3hWQT09IiwiZXhwIjoxNzIxNjQ3NTcyfQ.hnUnXydlcsLcfBH5Bay5ANm4aLl8e7amYPcXWeEH9cY"

            val validateUserResponse = client.validateUser(
                ValidateUserRequest.Builder()
                    .refreshToken(refreshToken)
                    .accessToken(accessToken)
                    .build()
            )

            Log.d(TAG, "onCreate: ${validateUserResponse.data?.user?.id}")
        }
    }
}