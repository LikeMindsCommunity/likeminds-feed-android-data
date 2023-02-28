package com.likeminds.feedsdk

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.internalsdk.post.model.Attachment
import com.likeminds.internalsdk.post.model.AttachmentMeta
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.GetPostRequest
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
                InitiateUserRequest.Builder().userId(
                    "433dc57b-12af-4b0d-a4b4-8e3e24b2c8de"
                )
                    .userName("Ankit SDK")
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

            val getPostResult = client.getPost(
                GetPostRequest.Builder().postId("63f5da50c52f148210f74970")
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

            val postResult = client.addPost(
                AddPostRequest.Builder().text("Post with image")
                    .attachments(
                        mutableListOf(
                            Attachment.Builder()
                                .attachmentType(1)
                                .attachmentMeta(
                                    AttachmentMeta.Builder()
                                        .name("images.jpeg")
                                        .localFilePath("/storage/emulated/0/Pictures/07c47495-0.png")
                                        .build()
                                )
                                .build()
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