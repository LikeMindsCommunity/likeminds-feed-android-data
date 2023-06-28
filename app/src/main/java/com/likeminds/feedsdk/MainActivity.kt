package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedRequest
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
                    .apiKey("97cb8c16-4eb2-4141-a882-dfc7fe4d43ac")
                    .userId("siddharth-2")
                    .deviceId("23344")
                    .userName("Ads")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "initiateResponse: ${initiateResponse.data?.user?.sdkClientInfo?.uuid}")

            val memberStateResponse = client.getMemberState()

            Log.d(TAG, "memberStateResponse: ${memberStateResponse.data?.uuid}")

            val notificationFeedResponse =
                client.getNotificationFeed(
                    GetNotificationFeedRequest.Builder()
                        .page(1)
                        .pageSize(10)
                        .build()
                )

            Log.d(
                TAG, """
                notificationFeedResponse: ${
                    notificationFeedResponse.data?.users?.forEach {
                        it.value.sdkClientInfo?.uuid
                    }
                }
            """.trimIndent()
            )
        }
    }
}