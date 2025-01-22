package com.likeminds.internalsdk.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.likeminds.internalsdk.db.dao.*
import com.likeminds.internalsdk.db.model.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class,
        AttachmentEntity::class,
        MemberRightsEntity::class,
        TopicEntity::class,
        ConfigurationEntity::class,
        PostSeenEntity::class
    ], version = LMFeedDbConstants.DB_VERSION, exportSchema = false
)
abstract class LMFeedRoomDatabase : RoomDatabase() {

    //User related Queries
    abstract fun userDao(): UserWithRightsDao

    //Post with attachments Queries
    abstract fun postWithAttachmentsDao(): PostWithAttachmentsDao

    //Community Configuration related queries
    abstract fun configurationDao(): ConfigurationDao

    //Post seen related queries
    abstract fun postSeenDao(): PostSeenDao
}