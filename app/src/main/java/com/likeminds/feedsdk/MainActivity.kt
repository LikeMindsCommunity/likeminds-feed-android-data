package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.Attachment
import com.likeminds.likemindsfeed.post.model.AttachmentType
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
                    .apiKey("4f881a74-8d0b-4c73-9f60-3d2370216392")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "onCreate: ${initiateResponse.data?.user?.id}")

            val attachments = listOf<Attachment>(
                Attachment.Builder()
                    .attachmentType(AttachmentType.IMAGE)
                    .attachmentMeta(JSONObject().apply {
                        put("name", "ABC")
                        put("size", 100000L)
                        put("url", "kllkl")
                        put("height", 19009)
                        put("weight", 89898)
                    })
                    .build(),
                Attachment.Builder()
                    .attachmentType(AttachmentType.CUSTOM_WIDGET)
                    .attachmentMeta(JSONObject().apply {
                        put("water", 4)
                    })
                    .build()
            )

            val addPostRequest = AddPostRequest.Builder()
                .text("test Post")
                .attachments(attachments)
                .build()

            val addPostResponse = client.addPost(addPostRequest)
            Log.d(
                TAG, """
                addPostResponse
                success: ${addPostResponse.success}
                errorMessage: ${addPostResponse.errorMessage}
            """.trimIndent()
            )
        }
    }
}