package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedRequest
import com.likeminds.likemindsfeed.post.model.GetPostLikesRequest
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
                    .apiKey("6b11d5f6-19fc-48aa-9140-0f59c88b0d0a")
                    .userId("564578")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "initiateResponse: ${initiateResponse.data?.user?.sdkClientInfo?.uuid}")

            val getUniversalFeedResponse =
                client.getFeed(GetFeedRequest.Builder().page(1).pageSize(10).build())

            Log.d(
                TAG, """
                getUniversalFeedResponse
                getUniversalFeedResponse: ${
                    getUniversalFeedResponse.data?.posts?.map {
                        it.uuid
                    }
                }
            """.trimIndent()
            )

            val postsId = getUniversalFeedResponse.data?.posts?.map {
                it.id
            }

            postsId?.forEach { postId ->
                val likes = client.getPostLikes(
                    GetPostLikesRequest.Builder()
                        .postId(postId)
                        .page(1)
                        .pageSize(10)
                        .build()
                )

                Log.d(
                    TAG, """
                    likes: ${
                        likes.data?.likes?.map {
                            it.uuid
                        }
                    }
                """.trimIndent()
                )
            }

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
               notificationFeedResponse: deletedByUUID ${
                    notificationFeedResponse.data?.activities?.map {
                        it.activityEntityData?.deletedByUUID
                    }
                }
                
               uuid ${
                    notificationFeedResponse.data?.activities?.map {
                        it.uuid
                    }
                }
           """.trimIndent()
            )
        }
    }
}