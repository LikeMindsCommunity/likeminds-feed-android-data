package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.topic.model.Topic

data class GetCurrentUploadingPostResponse(
    val post: Post,
    val topics: List<Topic> = emptyList()
)