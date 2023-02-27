package com.likeminds.likemindsfeed.sdk.utils

import com.likeminds.internalsdk.BuildConfig
import com.likeminds.internalsdk.TokenManager

object FileUtils {

    fun getFileNameFromPath(
        filePath: String?
    ): String? {
        return filePath?.substring(filePath.lastIndexOf("/") + 1);
    }

    fun generateUrlFromAWSFolderPath(
        awsFolderPath: String?
    ): String {
        return BuildConfig.URLS_MAP[BuildConfig.BUCKET_BASE_URL] + awsFolderPath
    }

    fun generateAWSFolderPathFromFilePath(
        filePath: String?
    ): String {
        val tokenManager = TokenManager.getInstance()
        val userId = tokenManager.memberId
        return "post/$userId/" + getFileNameFromPath(
            filePath
        ) + "-" + System.currentTimeMillis()
    }
}