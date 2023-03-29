package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.helper.model.DecodeUrlRequest
import com.likeminds.likemindsfeed.helper.model.GetTaggingListRequest
import com.likeminds.likemindsfeed.helper.model.RegisterDeviceRequest
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.initiateUser.model.LogoutRequest
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
                    .apiKey("6a4cc38e-02c7-4dfa-96b7-68a3078ad922")
                    .userId("299dc20c-72e1-49cf-8018-8ae33208d0a2")
                    .deviceId("233")
                    .userName("Mahir Gupta")
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
            Log.d("TAG", "logout: ${getTagging.success}")
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${getTagging.data?.members?.size}",
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
            val memberStateResult = client.getMemberState()
            Log.d("TAG", "memberStateResult: ${memberStateResult.toString()}")
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