package com.likeminds.feedsdk

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.internalsdk.post.model.Attachment
import com.likeminds.internalsdk.post.model.AttachmentMeta
import com.likeminds.internalsdk.post.model.LinkOGTags
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.moderation.model.GetReportTagsRequest
import com.likeminds.likemindsfeed.moderation.model.PostReportRequest
import com.likeminds.likemindsfeed.post.model.*
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
                InitiateUserRequest.Builder().userId("433dc57b-12af-4b0d-a4b4-8e3e24b2c8de")
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

            val getPostLikesResult = client.getPostLikes(
                GetPostLikesRequest.Builder().postId("63f5da50c52f148210f74970")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result - likes: ${getPostLikesResult.data?.totalCount}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val deletePostResponse = client.deletePost(
                DeletePostRequest.Builder().postId("63f5da50c52f148210f74970")
                    .deleteReason("Reason is this")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result ${deletePostResponse.errorMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val likePostResponse = client.likePost(
                LikePostRequest.Builder().postId("63f5da50c52f148210f74970")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result ${likePostResponse.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val savePostResponse = client.savePost(
                SavePostRequest.Builder().postId("63f5da50c52f148210f74970")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result ${savePostResponse.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val pinPostResponse = client.pinPost(
                PinPostRequest.Builder().postId("63f5da50c52f148210f74970")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result ${pinPostResponse.errorMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getReportTagsResponse = client.getReportTags(
                GetReportTagsRequest.Builder().type(0)
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result - tags size -> ${getReportTagsResponse.data?.tags?.size}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val postReportResponse = client.postReport(
                PostReportRequest.Builder().entityType(5)
                    .entityCreatorId("299dc20c-72e1-49cf-8018-8ae33208d0a2")
                    .entityId("63d0ebd885f97dea25f6cca7")
                    .tagId(6)
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result ${postReportResponse.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

//            val postResult = client.addPost(
//                AddPostRequest.Builder().text("testinggg")
//                    .attachments(
//                        listOf(
//                            Attachment(
//                                4,
//                                AttachmentMeta(
//                                    ogTags = LinkOGTags(
//                                        "Youtube video",
//                                        "https://i.ytimg.com/vi/EbyAoYaUcVo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDiI5bXtT71sC4IAnHiDAh52LxbFA",
//                                        "This is a youtube video",
//                                        "https://www.youtube.com/watch?v=sAuQjwEl-Bo"
//                                    )
//                                )
//                            )
//                        )
//                    )
//                    .build()
//            )
//            withContext(Dispatchers.Main) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "result: ${postResult.success}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
        }
    }
}