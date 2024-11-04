package com.likeminds.likemindsfeed.post.model

import com.likeminds.likemindsfeed.comment.model.Comment

class Post private constructor(
    val id: String,
    val text: String,
    val attachments: List<Attachment>?,
    val communityId: Int,
    val isLiked: Boolean,
    val isEdited: Boolean,
    val isPinned: Boolean,
    val userId: String,
    val likesCount: Int,
    val commentsCount: Int,
    val isSaved: Boolean,
    val menuItems: List<MenuItem>,
    val replies: List<Comment>?,
    val createdAt: Long,
    val updatedAt: Long,
    val uuid: String,
    val heading: String?,
    val tempId: String?,
    val topicIds: List<String>?,
    val workerUUID: String?,
    val isPosted: Boolean,
    val commentIds: List<String>?
) {
    class Builder {
        private var id: String = ""
        private var text: String = ""
        private var attachments: List<Attachment>? = null
        private var communityId: Int = 0
        private var isLiked: Boolean = false
        private var isEdited: Boolean = false
        private var isPinned: Boolean = false
        private var userId: String = ""
        private var likesCount: Int = 0
        private var commentsCount: Int = 0
        private var isSaved: Boolean = false
        private var menuItems: List<MenuItem> = emptyList()
        private var replies: List<Comment>? = null
        private var createdAt: Long = 0L
        private var updatedAt: Long = 0L
        private var uuid: String = ""
        private var heading: String? = null
        private var tempId: String? = null
        private var topicIds: List<String>? = null
        private var workerUUID: String? = null
        private var isPosted: Boolean = true
        private var commentIds: List<String>? = null

        fun id(id: String) = apply {
            this.id = id
        }

        fun text(text: String) = apply {
            this.text = text
        }

        fun communityId(communityId: Int) = apply {
            this.communityId = communityId
        }

        fun attachments(attachments: List<Attachment>?) = apply {
            this.attachments = attachments
        }

        fun isLiked(isLiked: Boolean) = apply {
            this.isLiked = isLiked
        }

        fun isEdited(isEdited: Boolean) = apply {
            this.isEdited = isEdited
        }

        fun isPinned(isPinned: Boolean) = apply {
            this.isPinned = isPinned
        }

        fun userId(userId: String) = apply {
            this.userId = userId
        }

        fun likesCount(likesCount: Int) = apply {
            this.likesCount = likesCount
        }

        fun commentCount(commentsCount: Int) = apply {
            this.commentsCount = commentsCount
        }

        fun isSaved(isSaved: Boolean) = apply {
            this.isSaved = isSaved
        }

        fun menuItems(menuItems: List<MenuItem>) = apply {
            this.menuItems = menuItems
        }

        fun replies(replies: List<Comment>?) = apply {
            this.replies = replies
        }

        fun createdAt(createdAt: Long) = apply {
            this.createdAt = createdAt
        }

        fun updatedAt(updatedAt: Long) = apply {
            this.updatedAt = updatedAt
        }

        fun uuid(uuid: String) = apply {
            this.uuid = uuid
        }

        fun heading(heading: String?) = apply {
            this.heading = heading
        }

        fun tempId(tempId: String?) = apply {
            this.tempId = tempId
        }

        fun topicIds(topicIds: List<String>?) = apply {
            this.topicIds = topicIds
        }

        fun workerUUID(workerUUID: String?) = apply {
            this.workerUUID = workerUUID
        }

        fun isPosted(isPosted: Boolean) = apply {
            this.isPosted = isPosted
        }

        fun commentIds(commentIds: List<String>?) = apply {
            this.commentIds = commentIds
        }

        fun build() = Post(
            id,
            text,
            attachments,
            communityId,
            isLiked,
            isEdited,
            isPinned,
            userId,
            likesCount,
            commentsCount,
            isSaved,
            menuItems,
            replies,
            createdAt,
            updatedAt,
            uuid,
            heading,
            tempId,
            topicIds,
            workerUUID,
            isPosted,
            commentIds
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .text(text)
            .attachments(attachments)
            .communityId(communityId)
            .isLiked(isLiked)
            .isEdited(isEdited)
            .isPinned(isPinned)
            .userId(userId)
            .likesCount(likesCount)
            .commentCount(commentsCount)
            .isSaved(isSaved)
            .menuItems(menuItems)
            .replies(replies)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .uuid(uuid)
            .heading(heading)
            .tempId(tempId)
            .topicIds(topicIds)
            .workerUUID(workerUUID)
            .isPosted(isPosted)
            .commentIds(commentIds)
    }

    override fun toString(): String {
        return buildString {
            append("Post(id='")
            append(id)
            append("', text='")
            append(text)
            append("', attachments=")
            append(attachments)
            append(", communityId=")
            append(communityId)
            append(", isLiked=")
            append(isLiked)
            append(", isEdited=")
            append(isEdited)
            append(", isPinned=")
            append(isPinned)
            append(", userId='")
            append(userId)
            append("', likesCount=")
            append(likesCount)
            append(", commentsCount=")
            append(commentsCount)
            append(",")
            append("isSaved=")
            append(isSaved)
            append(", menuItems=")
            append(menuItems)
            append(", replies=")
            append(replies)
            append(", createdAt=")
            append(createdAt)
            append(", updatedAt=")
            append(updatedAt)
            append(", uuid='")
            append(uuid)
            append("', heading='")
            append(heading)
            append("', tempId='")
            append(tempId)
            append("', topicIds=")
            append(topicIds)
            append(", workerUUID='")
            append(workerUUID)
            append("', isPosted=")
            append(isPosted)
            append("', commentIds=")
            append(commentIds)
            append(")")
        }
    }
}