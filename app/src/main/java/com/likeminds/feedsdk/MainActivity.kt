package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.comment.model.EditCommentRequest
import com.likeminds.likemindsfeed.helper.model.DecodeUrlRequest
import com.likeminds.likemindsfeed.helper.model.GetTaggingListRequest
import com.likeminds.likemindsfeed.helper.model.RegisterDeviceRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.LogoutRequest
import com.likeminds.likemindsfeed.notificationfeed.model.GetNotificationFeedRequest
import com.likeminds.likemindsfeed.post.model.EditPostRequest
import com.likeminds.likemindsfeed.post.model.GetPostRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = LMFeedClient.getInstance()
        CoroutineScope(Dispatchers.IO).launch {
            val clientResult = client.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("97cb8c16-4eb2-4141-a882-dfc7fe4d43ac")
                    .userId("siddharth-2")
                    .deviceId("23344")
                    .userName("Ads")
                    .isGuest(false)
                    .build()
            )

            val refreshToken = clientResult.data?.refreshToken

            Log.d("TAG", "onCreate: ${client.getMemberState()}")

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

            val editPostResult = client.editPost(
                EditPostRequest.Builder().postId("643520269c5a7fb3ac013ec0")
                    .text("This post is edited!")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Log.d(
                    "PUI", """
                    $editPostResult
                """.trimIndent()
                )
            }

            val editCommentResult = client.editComment(
                EditCommentRequest.Builder().postId("643520269c5a7fb3ac013ec0")
                    .commentId("643d1557a563b0ca5b38928a")
                    .text("This comment is edited!")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Log.d(
                    "PUI", """
                    $editCommentResult
                """.trimIndent()
                )
            }

//            val postResult = client.addPost(
//                AddPostRequest.Builder().text("testinggg")
//                    .attachments(
//                        listOf(
//                            Attachment.Builder()
//                                .attachmentType(1)
//                                .attachmentMeta(
//                                    AttachmentMeta.Builder()
//                                        .url("https://beta-likeminds-media.s3.amazonaws.com/post/87832/images.jpeg-1678447018540")
//                                        .build()
//                                )
//                                .build()
//                        )
//                    )
//                    .build()
//            )
            val decodeUrlResult = client.decodeUrl(
                DecodeUrlRequest.Builder()
                    .url("https://betadashboard.likeminds.community/community/chatrooms")
                    .build()
            )
            Log.d("TAG", "onCreate: ${decodeUrlResult.data?.ogTags?.title}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${decodeUrlResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val deviceId =
                Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)

            val registerDeviceResult = client.registerDevice(
                RegisterDeviceRequest.Builder().deviceId(deviceId).token("yuyu").build()
            )
            Log.d("TAG", "register device: ${registerDeviceResult.success}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${registerDeviceResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getTagging = client.getTaggingList(
                GetTaggingListRequest.Builder()
                    .page(1)
                    .pageSize(10)
                    .searchName("mah")
                    .build()
            )
            Log.d("TAG", "getTagging: ${getTagging.success}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${getTagging.data?.members?.size}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getNotificationFeedResult = client.getNotificationFeed(
                GetNotificationFeedRequest.Builder()
                    .page(1)
                    .pageSize(5)
                    .build()
            )
            Log.d("TAG", "getNotificationFeedResult: ${getNotificationFeedResult.data}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${getNotificationFeedResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getUnreadNotificationCountResult = client.getUnreadNotificationCount()
            Log.d(
                "TAG",
                "getUnreadNotificationCountResult: ${getUnreadNotificationCountResult.data}"
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${getUnreadNotificationCountResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val memberStateResult = client.getMemberState()
            Log.d(
                "TAG", """
                ${memberStateResult.data}
            """.trimIndent()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${memberStateResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val logoutResult = client.logout(
                LogoutRequest.Builder()
                    .refreshToken(refreshToken ?: "")
                    .deviceId(deviceId)
                    .build()
            )
            Log.d("TAG", "logout: ${logoutResult.success}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${logoutResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}