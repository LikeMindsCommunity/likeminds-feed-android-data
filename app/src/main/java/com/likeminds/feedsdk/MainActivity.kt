package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.poll.model.*
import com.likeminds.likemindsfeed.post.model.*
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
                    .apiKey("69edd43f-4a5e-4077-9c50-2b7aa740acce")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            val pollAttachment = Attachment.Builder()
                .attachmentType(AttachmentType.POLL)
                .attachmentMeta(
                    AttachmentMeta.Builder()
                        .title("Test Poll")
                        .expiryTime(1716179508000)
                        .pollOptions(listOf("Option 1", "Option 2", "Option 3"))
                        .allowAddOption(true)
                        .multiSelectNumber(2)
                        .multiSelectState(PollMultiSelectState.EXACTLY)
                        .build()
                )
                .build()

            val createPollRequest = AddPostRequest.Builder()
                .text("Test Poll Post")
                .heading("Test Poll Heading")
                .attachments(listOf(pollAttachment))
                .build()

            val createPollResponse = client.addPost(createPollRequest)

            Log.d(
                TAG, """
                createPollResponse:${createPollResponse.success}
                createPollResponse:${
                    createPollResponse.data?.widgets?.values?.map {
                        it
                    }
                }
            """.trimIndent()
            )

            val pollId =
                createPollResponse.data?.post?.attachments?.firstOrNull()?.attachmentMeta?.entityId
                    ?: ""
            Log.d(TAG, "poll id: $pollId")

            val addPollOptionRequest = AddPollOptionRequest.Builder()
                .pollId(pollId)
                .text("Option 4")
                .build()
            val addPollResponse = client.addPollOption(addPollOptionRequest)

            Log.d(
                TAG, """
                addPollResponse: ${addPollResponse.data?.widget}
            """.trimIndent()
            )

            val optionIds = addPollResponse.data?.widget?.lmMeta?.options?.map {
                it.id
            }?.subList(0, 2) ?: emptyList()

            val submitVoteRequest = SubmitVoteRequest.Builder()
                .pollId(pollId)
                .votes(optionIds)
                .build()

            val submitVoteResponse = client.submitVote(submitVoteRequest)

            Log.d(
                TAG, """
                submitVoteResponse: ${submitVoteResponse.success} ${submitVoteResponse.errorMessage}
            """.trimIndent()
            )

            val getPollResponse = client.getPollVotes(
                GetPollVotesRequest.Builder()
                    .pollId(pollId)
                    .votes(optionIds)
                    .build()
            )

            Log.d(
                TAG, """
                getPollResponse: ${getPollResponse.success}
                getPollResponse:${
                    getPollResponse.data?.votes?.map {
                        it.userIds.size
                    }
                }
            """.trimIndent()
            )
        }
    }
}