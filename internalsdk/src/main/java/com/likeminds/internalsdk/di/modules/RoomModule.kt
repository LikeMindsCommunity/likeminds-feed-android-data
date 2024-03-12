package com.likeminds.internalsdk.di.modules

import android.content.Context
import androidx.room.Room
import com.likeminds.internalsdk.db.LMFeedRoomDatabase
import com.likeminds.internalsdk.db.dao.UserWithRightsDao
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants
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
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserWithRightsDao(db: LMFeedRoomDatabase): UserWithRightsDao {
        return db.userDao()
    }
}