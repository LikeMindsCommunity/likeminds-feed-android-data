package com.likeminds.internalsdk.di.modules

import android.content.Context
import androidx.room.Room
import com.likeminds.internalsdk.db.LMFeedRoomDatabase
import com.likeminds.internalsdk.db.dao.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants
import com.likeminds.internalsdk.db.utils.LMFeedDbMigration
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun providesLMFeedDatabase(context: Context): LMFeedRoomDatabase {
        return Room.databaseBuilder(
            context,
            LMFeedRoomDatabase::class.java,
            LMFeedDbConstants.DB_NAME
        ).addMigrations(
            LMFeedDbMigration.MIGRATION_1_2,
            LMFeedDbMigration.MIGRATION_2_3,
            LMFeedDbMigration.MIGRATION_3_4,
            LMFeedDbMigration.MIGRATION_4_5
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUserWithRightsDao(db: LMFeedRoomDatabase): UserWithRightsDao {
        return db.userDao()
    }

    @Provides
    @Singleton
    fun providesPostWithAttachmentsDao(db: LMFeedRoomDatabase): PostWithAttachmentsDao {
        return db.postWithAttachmentsDao()
    }

    @Provides
    @Singleton
    fun provideConfigurationDao(db: LMFeedRoomDatabase): ConfigurationDao {
        return db.configurationDao()
    }

    @Provides
    @Singleton
    fun providesPostSeenDao(db: LMFeedRoomDatabase): PostSeenDao {
        return db.postSeenDao()
    }
}