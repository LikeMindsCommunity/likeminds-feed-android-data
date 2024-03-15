package com.likeminds.internalsdk.db.dao

import androidx.room.*
import com.likeminds.internalsdk.db.model.*
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Dao
interface UserWithRightsDao {

    //add user in local db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    //inserts user along with rights in local db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserWithRights(user: UserEntity, memberRights: List<MemberRightsEntity>)

    //delete user in local db
    @Delete
    suspend fun deleteUser(user: UserEntity)

    //get user for a particular user.uuid
    @Query("SELECT * FROM ${LMFeedDbConstants.USER_TABLE} WHERE user_unique_id =:uuid")
    suspend fun getUser(uuid: String): UserEntity?

    @Transaction
    @Query("SELECT * FROM ${LMFeedDbConstants.USER_TABLE} LIMIT 1")
    suspend fun getLoggedInUserWithRights():UserWithRights?
}