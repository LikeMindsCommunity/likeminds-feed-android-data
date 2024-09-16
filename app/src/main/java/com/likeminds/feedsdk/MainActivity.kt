package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.comment.model.AddCommentRequest
import com.likeminds.likemindsfeed.feed.model.GetFeedRequest
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.Attachment
import com.likeminds.likemindsfeed.post.model.AttachmentType
import com.likeminds.likemindsfeed.post.model.DeletePostRequest
import com.likeminds.likemindsfeed.post.model.EditPostRequest
import com.likeminds.likemindsfeed.post.model.LikePostRequest
import com.likeminds.likemindsfeed.search.model.GetSearchPostsRequest
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
import com.likeminds.likemindsfeed.user.model.ValidateUserRequest
import kotlinx.coroutines.*
import org.json.JSONObject

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
                    .apiKey("712c3e1a-d10c-4bd5-bb52-21b903471958")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "onCreate: ${initiateResponse.data?.user?.name}")


//            val getFeedReq = GetFeedRequest.Builder()
//                .page(1)
//                .pageSize(10)
//                .build()
//
//            val getFeedResponse = client.getFeed(getFeedReq)
//
//            Log.d(
//                TAG, """
//                getFeedResponse = ${
//                    getFeedResponse.data?.posts?.map {
//                        it.text
//                    }
//                }
//            """.trimIndent()
//            )

        }
    }
}