package com.likeminds.internalsdk.db.utils

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object LMFeedDbMigration {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {

            //change in user table
            database.execSQL(
                "DROP TABLE ${LMFeedDbConstants.USER_TABLE}"
            )

            //create new user table
            database.execSQL(
                "CREATE TABLE IF NOT EXISTS ${LMFeedDbConstants.USER_TABLE} (`id` INTEGER NOT NULL," +
                        "`image_url` TEXT NOT NULL," +
                        "`is_guest` INTEGER NOT NULL," +
                        "`name` TEXT NOT NULL," +
                        "`updated_at` INTEGER NOT NULL," +
                        "`custom_title` TEXT," +
                        "`is_deleted` INTEGER," +
                        "`user_unique_id` TEXT NOT NULL," +
                        "`state` INTEGER NOT NULL DEFAULT 4," +
                        "`is_owner` INTEGER NOT NULL," +
                        "`uuid` TEXT NOT NULL DEFAULT ''," +
                        "`community` INTEGER NOT NULL DEFAULT 0," +
                        "`user` INTEGER NOT NULL DEFAULT 0," +
                        "`sdk_client_user_unique_id` TEXT NOT NULL DEFAULT ''," +
                        "`sdk_client_uuid` TEXT NOT NULL DEFAULT ''," +
                        "PRIMARY KEY(`id`, `user_unique_id`))"
            )

            //change in member rights table
            database.execSQL(
                "DROP TABLE ${LMFeedDbConstants.MEMBER_RIGHTS_TABLE}"
            )

            //create new member rights table
            database.execSQL(
                "CREATE TABLE IF NOT EXISTS ${LMFeedDbConstants.MEMBER_RIGHTS_TABLE} (`id` INTEGER NOT NULL," +
                        "`is_locked` INTEGER DEFAULT 0," +
                        "`is_selected` INTEGER NOT NULL DEFAULT 1," +
                        "`state` INTEGER NOT NULL," +
                        "`title` TEXT NOT NULL," +
                        "`subtitle` TEXT," +
                        "`user_unique_id` TEXT NOT NULL," +
                        "PRIMARY KEY(`user_unique_id`, `id`))"
            )
        }
    }
    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE ${LMFeedDbConstants.ATTACHMENT_TABLE} ADD `custom_widget_meta` TEXT"
            )
        }
    }
}