package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.topic.model.Topic

class AddTemporaryPostRequest private constructor(
    val post: Post,
    val topics: List<Topic>,
    val postThumbnail: String?
) {
    class Builder {
        private var post: Post = Post.Builder().build()
        private var topics: List<Topic> = emptyList()
        private var postThumbnail: String? = null

        fun post(post: Post) = apply { this.post = post }
        fun topics(topics: List<Topic>) = apply { this.topics = topics }
        fun postThumbnail(postThumbnail: String?) = apply { this.postThumbnail = postThumbnail }

        fun build() = AddTemporaryPostRequest(post, topics, postThumbnail)
    }

    fun toBuilder(): Builder {
        return Builder().post(post)
            .topics(topics)
            .postThumbnail(postThumbnail)
    }
}