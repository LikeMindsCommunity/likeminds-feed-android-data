package com.likeminds.feedsdk

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.internalsdk.post.model.Attachment
import com.likeminds.internalsdk.post.model.AttachmentMeta
import com.likeminds.internalsdk.post.model.LinkOGTags
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.post.model.AddPostRequest
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
                    "result: ${clientResult.initiateUser?.user?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val brandingResult = client.getBranding(
                BrandingRequest.Builder().communityId("50418").build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${brandingResult.branding?.basic?.primaryColor}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val universalFeedResult = client.getFeed(
                GetFeedRequest.Builder().page(1).build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: total posts = ${universalFeedResult.data?.posts?.size}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val postResult = client.addPost(
                AddPostRequest.Builder().text("Posting from Android SDK another one")
                    .attachments(
                        listOf(
                            Attachment(
                                4,
                                AttachmentMeta(
                                    ogTags = LinkOGTags(
                                        "Youtube video",
                                        "https://i.ytimg.com/vi/EbyAoYaUcVo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDiI5bXtT71sC4IAnHiDAh52LxbFA",
                                        "This is a youtube video",
                                        "https://www.youtube.com/watch?v=sAuQjwEl-Bo"
                                    )
                                )
                            )
                        )
                    )
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${postResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}