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
            val initiateResponse = client.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("4f881a74-8d0b-4c73-9f60-3d2370216392")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )
//
//            val accessToken =
//                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoibmtRSlN6SWpuazQrL2VnRUMwNjIvM1ZSaHEvQVNreFBWaGROUk5VNVlOb09UV0dHWWNkbm1ibS9DRUxBMDJJVjhIbHhoNG9Bb2FBZm4yd1hxRVRnaXRlcVFHcjZ0b1ZQUzMxa1NuVHNPb3M3ZmVQZVdrOHArNTRVbzl4eVUyQmIzMzBFTHdCRkhYR05UdWNBMjgxVk5MMVNtV1dCdDZ0eUFLSUJZWldraTlMdGhBSmlHWEtyV0RIUnhmRGdFMjc0NTJNUXIvSnRNamRYMjlkeCtuZVV6di8wNjJ3Ump4bkJEVnkzcTZlNXBjZ0NLb1R0NERYSlRxSEpnc0VSNjIybmV6QzloTnpzdmNJUU1uaCsiLCJleHAiOjE3MTg4ODE3NzJ9.yxsRQPNMEjeJt6oJ2QRNbZx3BaPf30w8uAgHLV5RVGU"
//            val refreshToken =
//                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiemtpQzAwSjhxbXZ4dGFick44SU0vUUtlZlo4MnFoK1hCemZadHBWSExPT2lxcTkzc1hXYjdpS2YxbGlyV2pIdGdCbGxFL1hRTmZZYloyZXZ6SnZ6dW9LdkpxQmI2TUlnZWwxV0hiSVV5UnJMK1A5OVgzb1VVSGdMVWNrRWdZbXhueDhWUXVwQ1N2eWk3eFpxM0t5cUdyTUpyMHB5MHBkSWVHMHF0V3dvV3RBaXgrR3dKVTRiQ1NYUG5ySHVJbThhUnd5U2N4YkNYSG9TcWJnbDZFa2ZSVlBQeVlYVStXSzl6SWNVUVpYRWdybjRVWmxBWm5WcHZmTExSa1BiQW5Ba285MUdqckM0SWN0cHNGMVBOQT09IiwiZXhwIjoxNzIxNTU2NTcyfQ.j4hqEKSYYYvxIJObF7aPW7T11RZCvZFaTlMf5OgtF1A"
//
//            val validateUserResponse = client.validateUser(
//                ValidateUserRequest.Builder()
//                    .refreshToken(refreshToken ?: "")
//                    .accessToken(accessToken ?: "")
//                    .build()
//            )

            Log.d(TAG, "onCreate: ${initiateResponse.data?.user?.id}")

            val apiKey = client.getAPIKey()
            Log.d(TAG, "onCreate: ${apiKey.data}")

            val tokens = client.getTokens()
            Log.d(TAG, "onCreate: ${tokens.data?.first}")
            Log.d(TAG, "onCreate: ${tokens.data?.second}")
        }
    }
}