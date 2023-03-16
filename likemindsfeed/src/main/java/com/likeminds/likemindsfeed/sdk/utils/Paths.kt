package com.likeminds.likemindsfeed.sdk.utils

import android.content.ContentResolver
import android.net.Uri
import android.webkit.MimeTypeMap
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.PATH_DOWNLOAD
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.PATH_EXTERNAL_STORAGE
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.PATH_MEDIA
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.PATH_RAW_DOWNLOAD

/**
 * Checks Uri authority
 *
 */
internal val Uri.isExternalStorageDocument get() = PATH_EXTERNAL_STORAGE == authority

internal val Uri.isDownloadsDocument get() = PATH_DOWNLOAD == authority

internal val Uri.isMediaDocument get() = PATH_MEDIA == authority

internal val Uri.isRawDownloadsDocument get() = toString().contains(PATH_RAW_DOWNLOAD)

internal val Uri.isFile get() = "file".equals(scheme, ignoreCase = true)

internal fun Uri.isUnknownProvider(
    returnedPath: String,
    contentResolver: ContentResolver
): Boolean {
    val mime = MimeTypeMap.getSingleton()
    val subStringExtension =
        returnedPath.substring(returnedPath.lastIndexOf(".") + 1)
    val extensionFromMime =
        mime.getExtensionFromMimeType(contentResolver.getType(this))
    return scheme.let { subStringExtension != extensionFromMime && it == ContentResolver.SCHEME_CONTENT }
}