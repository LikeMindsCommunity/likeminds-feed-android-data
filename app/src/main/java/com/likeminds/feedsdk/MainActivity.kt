package com.likeminds.feedsdk

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.comment.model.AddCommentRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.universalfeed.model.GetFeedRequest
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
                InitiateUserRequest.Builder().userId("299dc20c-72e1-49cf-8018-8ae33208d0a2")
                    .userName("Mahir Gupta")
                    .isGuest(false)
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${clientResult?.initiateUser?.user?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val brandingResult = client.getBranding(
                BrandingRequest.Builder().communityId("50418").build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${brandingResult?.branding?.basic?.primaryColor}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val universalFeedResult = client.getFeed(
                GetFeedRequest.Builder().page(1).build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: total posts = ${universalFeedResult?.data?.posts?.size}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val addCommentResult = client.addComment(
                AddCommentRequest.Builder()
                    .postId("63f4caadc52f148210f7496a")
                    .text("Adding another comment from Android SDK")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${addCommentResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}