package com.likeminds.likemindsfeed.sdk.utils

import android.annotation.SuppressLint
import android.provider.MediaStore

object Constants {

    object PathUri {
        //Local
        private const val PATH_ANDROID = "com.android"
        const val PATH_EXTERNAL_STORAGE = "$PATH_ANDROID.externalstorage.documents"
        const val PATH_DOWNLOAD = "$PATH_ANDROID.providers.downloads.documents"
        const val PATH_MEDIA = "$PATH_ANDROID.providers.media.documents"
        const val PATH_RAW_DOWNLOAD = "$PATH_DOWNLOAD/document/raw"

        //Folder
        const val FOLDER_DOWNLOAD = "Download"

        //Columns
        const val COLUMN_DISPLAY_NAME = MediaStore.Files.FileColumns.DISPLAY_NAME

        const val COLUMN_DATA = "_data"
    }

    object SDCard {
        @SuppressLint("SdCardPath")
        @JvmSynthetic
        val SDCARD_PATHS = arrayOf(
            "/storage/sdcard0",
            "/storage/sdcard1",
            "/storage/extsdcard",
            "/storage/sdcard0/external_sdcard",
            "/mnt/extsdcard",
            "/mnt/sdcard/external_sd",
            "/mnt/sdcard/ext_sd",
            "/mnt/external_sd",
            "/mnt/media_rw/sdcard1",
            "/removable/microsd",
            "/mnt/emmc",
            "/storage/external_SD",
            "/storage/ext_sd",
            "/storage/removable/sdcard1",
            "/data/sdext",
            "/data/sdext2",
            "/data/sdext3",
            "/data/sdext4",
            "/sdcard1",
            "/sdcard2",
            "/storage/microsd"
        )
    }
}