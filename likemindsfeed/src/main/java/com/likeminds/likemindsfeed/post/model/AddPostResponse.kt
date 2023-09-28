package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.topic.model.Topic
import com.likeminds.likemindsfeed.widgets.model.Widget

data class AddPostResponse(
    val post: Post,
    val users: Map<String, User>,
    val widgets: Map<String, Widget>,
    val topics: Map<String, Topic>
)