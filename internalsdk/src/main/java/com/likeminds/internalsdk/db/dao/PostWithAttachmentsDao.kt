package com.likeminds.internalsdk.db.dao

import androidx.room.*
import com.likeminds.internalsdk.db.model.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Dao
interface PostWithAttachmentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostWithAttachments(
        post: PostEntity,
        attachments: List<AttachmentEntity>,
        topics: List<TopicEntity>
    )

    //update post upload uuid in local db
    @Query("UPDATE ${LMFeedDbConstants.POST_TABLE} SET worker_uuid = :workerUUID WHERE temp_id =:temporaryId")
    suspend fun updateUploadWorkerUUID(temporaryId: String, workerUUID: String)

    // updates is_posted and post_id key in db
    @Query("UPDATE ${LMFeedDbConstants.POST_TABLE} SET post_id = :postId, is_posted = :isPosted WHERE temp_id =:temporaryId")
    suspend fun updateIsPosted(
        temporaryId: String?,
        postId: String,
        isPosted: Boolean
    )

    // updates post_id in attachments with temp_id
    @Query("UPDATE ${LMFeedDbConstants.ATTACHMENT_TABLE} SET post_id = :postId WHERE temp_id =:temporaryId")
    suspend fun updatePostIdInAttachments(postId: String, temporaryId: String?)

    //get the latest post in db which is not posted
    @Transaction
    @Query("SELECT * FROM ${LMFeedDbConstants.POST_TABLE} WHERE is_posted = 0 ORDER BY temp_id DESC LIMIT ${LMFeedDbConstants.LATEST_POST_LIMIT}")
    suspend fun getLatestPostWithAttachments(): PostWithAttachments?

    //get post for a particular post.id (temporaryId)
    @Transaction
    @Query("SELECT * FROM ${LMFeedDbConstants.POST_TABLE} WHERE temp_id = :temporaryId")
    suspend fun getPostWithAttachments(temporaryId: String): PostWithAttachments?
}