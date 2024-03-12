package com.likeminds.internalsdk.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.likeminds.internalsdk.db.dao.UserWithRightsDao
import com.likeminds.internalsdk.db.model.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class,
        AttachmentEntity::class,
        MemberRightsEntity::class,
        TopicEntity::class,
        ConfigurationEntity::class
    ], version = LMFeedDbConstants.DB_VERSION, exportSchema = false
)
abstract class LMFeedRoomDatabase : RoomDatabase() {

    //User related Queries
    abstract fun userDao():UserWithRightsDao
}