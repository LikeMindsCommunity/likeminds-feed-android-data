package com.likeminds.feedsdk

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.post.model.GetPostRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = LMFeedClient.getInstance()
        CoroutineScope(Dispatchers.IO).launch {
            val clientResult = client.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("6a4cc38e-02c7-4dfa-96b7-68a3078ad922")
                    .userId("299dc20c-72e1-49cf-8018-8ae33208d0a2")
                    .userName("Mahir Gupta")
                    .isGuest(false)
                    .build()
            )

            val getPostResult = client.getPost(
                GetPostRequest.Builder().postId("63f4caadc52f148210f7496a")
                    .page(1)
                    .pageSize(10)
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${getPostResult.data?.post?.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}