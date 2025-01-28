package com.likeminds.internalsdk.db.dao

import androidx.room.*
import com.likeminds.internalsdk.db.model.PostSeenEntity
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Dao
interface PostSeenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeenPost(postSeenEntity: PostSeenEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostSeenList(postSeenList: List<PostSeenEntity>)

    @Query("SELECT * FROM ${LMFeedDbConstants.POST_SEEN_TABLE}")
    suspend fun getAllSeenPost(): List<PostSeenEntity>?

    // 3. Delete all posts seen whose `seenAt` is less than the given timestamp
    @Query("DELETE FROM ${LMFeedDbConstants.POST_SEEN_TABLE} WHERE seen_at < :timestamp")
    suspend fun deletePostsSeenBefore(timestamp: Long)
}