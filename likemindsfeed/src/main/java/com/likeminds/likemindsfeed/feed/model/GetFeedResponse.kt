package com.likeminds.likemindsfeed.feed.model

import com.likeminds.likemindsfeed.comment.model.Comment
import com.likeminds.likemindsfeed.post.model.Post
import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.topic.model.Topic
import com.likeminds.likemindsfeed.widgets.model.Widget

data class GetFeedResponse(
    val posts: List<Post>,
    val users: Map<String, User>,
    val widgets: Map<String, Widget>,
    val topics: Map<String, Topic>,
    val filteredComments: Map<String, Comment>
)