package com.likeminds.feedsdk

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.comment.model.*
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.Attachment
import com.likeminds.likemindsfeed.post.model.AttachmentMeta
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
                    "result: ${clientResult.data?.initiateUser?.user?.name}",
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

            val getCommentResult = client.getComment(
                GetCommentRequest.Builder()
                    .postId("63f4caadc52f148210f7496a")
                    .commentId("63fd9172d487fc4450aba56e")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Log.d(
                    "TAG", "onCreate: " +
                            "count:" + getCommentResult.data?.comment?.commentsCount +
                            "\nmenu:" + getCommentResult.data?.comment?.menuItems?.get(0)?.title +
                            "\nreply:" + getCommentResult.data?.comment?.replies?.size + getCommentResult.data?.comment?.replies?.get(
                        0
                    )?.text +
                            "\nuser:" + getCommentResult.data?.users?.get(getCommentResult.data?.comment?.userId)?.name
                )
                Toast.makeText(
                    this@MainActivity,
                    "comment: ${getCommentResult.data?.comment?.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val likeCommentResult = client.likeComment(
                LikeCommentRequest.Builder()
                    .postId("63f4caadc52f148210f7496a")
                    .commentId("63fd9172d487fc4450aba56e")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "like comment: ${likeCommentResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getCommentLikesResult = client.getCommentLikes(
                GetCommentLikesRequest.Builder()
                    .postId("63f4caadc52f148210f7496a")
                    .commentId("63fd9172d487fc4450aba56e")
                    .page(1)
                    .pageSize(5)
                    .build()
            )
            withContext(Dispatchers.Main) {
                Log.d("TAG", getCommentLikesResult.data.toString())
                Toast.makeText(
                    this@MainActivity,
                    "get comment: ${getCommentLikesResult.data?.totalCount}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val getDeleteCommentResult = client.deleteComment(
                DeleteCommentRequest.Builder()
                    .postId("63f4caadc52f148210f7496a")
                    .commentId("63fd9172d487fc4450aba56e")
                    .build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "delete comment: ${getDeleteCommentResult.success}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val postResult = client.addPost(
                AddPostRequest.Builder().text("testinggg")
                    .attachments(
                        listOf(
                            Attachment.Builder()
                                .attachmentType(1)
                                .attachmentMeta(
                                    AttachmentMeta.Builder()
                                        .localFilePath("content://media/external/images/media/1000017745")
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