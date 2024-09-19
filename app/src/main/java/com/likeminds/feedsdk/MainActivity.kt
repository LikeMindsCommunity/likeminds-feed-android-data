package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.search.model.SearchPostsRequest
import com.likeminds.likemindsfeed.search.model.SearchType
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
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
                    .apiKey("712c3e1a-d10c-4bd5-bb52-21b903471958")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "onCreate: ${initiateResponse.data?.user?.name}")

            val searchPostsRequest = SearchPostsRequest.Builder()
                .page(1)
                .pageSize(10)
                .search("post")
                .searchType(SearchType.TEXT)
                .build()

            val response = client.searchPosts(searchPostsRequest)
        }
    }
}