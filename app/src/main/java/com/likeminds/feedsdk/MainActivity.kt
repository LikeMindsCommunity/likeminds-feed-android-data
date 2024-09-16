package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.comment.model.AddCommentRequest
import com.likeminds.likemindsfeed.feed.model.GetFeedRequest
import com.likeminds.likemindsfeed.post.model.AddPostRequest
import com.likeminds.likemindsfeed.post.model.Attachment
import com.likeminds.likemindsfeed.post.model.AttachmentType
import com.likeminds.likemindsfeed.post.model.DeletePostRequest
import com.likeminds.likemindsfeed.post.model.EditPostRequest
import com.likeminds.likemindsfeed.post.model.LikePostRequest
import com.likeminds.likemindsfeed.search.model.GetSearchPostsRequest
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
                    .apiKey("712c3e1a-d10c-4bd5-bb52-21b903471958")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            Log.d(TAG, "onCreate: ${initiateResponse.data?.user?.name}")


            val addPostRequest = AddPostRequest.Builder()
                .heading("Test Head")
                .text("c")
                .build()

//            val addPostResponse = client.addPost(addPostRequest)
//
//            Log.d(
//                TAG, """
//                addPostResponse = ${addPostResponse.data?.post?.heading}
//            """.trimIndent()
//            )

            val getFeedReq = GetFeedRequest.Builder()
                .page(1)
                .pageSize(10)
                .build()

            val getFeedResponse = client.getFeed(getFeedReq)

            Log.d(
                TAG, """
                getFeedResponse = ${
                    getFeedResponse.data?.posts?.map {
                        it.text
                    }
                }
            """.trimIndent()
            )


            // editPost
            val editPostRequest = EditPostRequest.Builder()
                .postId("66deb04f0a9d8fdebde50539")
                .text("This is the body text if the post is posted")
                .build()

            val editedPost = client.editPost(editPostRequest)
            Log.d(
                TAG, """
                editPostResponse = ${editedPost.data?.post?.text}
            """.trimIndent()
            )


            // deletePost
//            val deletePostReq = DeletePostRequest.Builder()
//                .postId("66deb04f0a9d8fdebde50539")
//                .build()
//            val deletePost = client.deletePost(deletePostReq)

            // likePost
            val likeReq = LikePostRequest.Builder().postId("66deb04f0a9d8fdebde50539").build()
            client.likePost(likeReq)
            Log.d(
                TAG, """
                getFeedResponse = ${
                    getFeedResponse.data?.posts?.map {
                        it.isLiked
                    }
                }
            """.trimIndent()
            )


            // addComment
            val addCommentReq = AddCommentRequest.Builder().postId("66deb04f0a9d8fdebde50539")
                .text("Post comment")
                .postId("66deb04f0a9d8fdebde50539")
                .build()
            val addedComm = client.addComment(addCommentReq)
            Log.d(
                TAG, """
                getComment = ${
                    addedComm.data?.comment?.text
                }
            """.trimIndent()
            )

            // SearchPosts
            val searchPostReq = GetSearchPostsRequest.Builder()
                .page(1)
                .pageSize(10)
                .search("for")
                .searchType("text")
                .build()

            val searcedPost = client.searchPosts(searchPostReq)
            Log.d(
                TAG, """
                getSearchedPost = ${
                    searcedPost.data?.posts
                }
            """.trimIndent()
            )
        }
    }
}