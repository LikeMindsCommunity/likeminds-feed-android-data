package com.likeminds.internalsdk.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.likeminds.internalsdk.db.model.ConfigurationEntity
import com.likeminds.internalsdk.db.utils.LMFeedDbConstants

@Dao
interface ConfigurationDao {
    //add all configurations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfigurations(configurations: List<ConfigurationEntity>)

    //get a particular configuration
    @Query("SELECT * FROM ${LMFeedDbConstants.CONFIGURATION_TABLE} WHERE type = :type")
    suspend fun getConfiguration(type: String): ConfigurationEntity?

    //get all configurations
    @Query("SELECT * FROM ${LMFeedDbConstants.CONFIGURATION_TABLE}")
    suspend fun getConfigurations(): List<ConfigurationEntity>?
}