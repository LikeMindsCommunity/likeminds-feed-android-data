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
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiQkpRMWZ6UnJqd2NFRk9hd1JVR3p3TWVHd09uOTRuVXpyTE9KdXRCTnh3Yjd2RUhQUC9HS01RYVdYalA0Z2ZBTGtRYnlOemFJR1NyK0xidXFPUVJnNjRVWlNXWHpYVUxmbUJwejFqMk5HTmFGREIxYlNFTFpHNC9UaGNNcmdyTFp4STRlNEVoL1JhcXM4eXRNNWprcWhKTUZ4cjZWS29CZVcvM25aYnFlelpBaWlVNk4xWU8vZHNaTURibU9nY3p2eHNGZUtza2lIdWRKeFF1QTFzcXpVLyt2WUNLMW9keWM2dnhvUytkbVd4SEZNeWtOOEJ6VUlZbnRQb2s5ZktIdVF6cXQ1ejBHc3ZvdDkxUFkiLCJleHAiOjE3MTgxOTMxNjR9.ygyXNf7XFciRUkIlsP_xppA2XlQqvEM7mYdu234GPX8"
            val refreshToken =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiankwbytJYktyT2lsVUs1aEJWdUl2a3RJT1NFanNOaHhqV1lWV0tGbTlEZlpwMU1hZkpiTXNnc3BRNDZJQXozSXROeUVjaHJMWDZpQ0VDZWtRM3VFTHZVZnFDazN5TVNVT2I2R3kwMWRmeU9pMFZvRWZmNjVKSjFPcEFkeG5XRHRiSWVyZzF6TnQ0cFBUTlFzRUQyNTA0UGNmdDlpNm5mekY0TXVuUXRQakFDR3NSUE9BSTdLaFZEVVRWb1Z4ZzZoMWtnU29JV1g2VlBIT0RxQUphZk50UE1sRFhMT0hTTzUvMWsrRW5JNXNLOGw0YlNFNW9ESzJWOTR4cytzOU8wRVVVUWY4Vy9rMXhzeE1iS3NSUT09IiwiZXhwIjoxNzIwODY3OTY0fQ.lL6GhT9uZJZPeibOHaZ8VBgNnfiupShtOAPQQ-k8Fd8"

            val validateUserResponse = client.validateUser(
                ValidateUserRequest.Builder()
                    .refreshToken(refreshToken ?: "")
                    .accessToken(accessToken ?: "")
                    .build()
            )
        }
    }
}