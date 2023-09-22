package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.sdk.model.User
import com.likeminds.likemindsfeed.widgets.model.Widget

data class AddPostResponse(
    val post: Post,
    val users: Map<String, User>,
    val widget: Map<String, Widget>
)