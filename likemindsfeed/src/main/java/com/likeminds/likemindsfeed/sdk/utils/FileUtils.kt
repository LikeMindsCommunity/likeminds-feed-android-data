package com.likeminds.likemindsfeed.sdk.utils

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import com.likeminds.internalsdk.BuildConfig
import com.likeminds.internalsdk.TokenManager
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.COLUMN_DATA
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.COLUMN_DISPLAY_NAME
import com.likeminds.likemindsfeed.sdk.utils.Constants.PathUri.FOLDER_DOWNLOAD
import com.likeminds.likemindsfeed.sdk.utils.ContentUriUtils.getPathFromColumn
import com.likeminds.likemindsfeed.sdk.utils.SDCardUtils.getStorageDirectories
import java.io.File
import java.io.FileOutputStream

object FileUtils {

    /**
     * @param filePath - Path of file in external storage
     * @return fileName - Name of the file in external storage
     */
    fun getFileNameFromPath(
        filePath: String?
    ): String? {
        return filePath?.substring(filePath.lastIndexOf("/") + 1)
    }

    /**
     * @param awsFolderPath - AWS folder path where file will be uploaded
     * @return url - Complete url to upload file to aws
     */
    fun generateUrlFromAWSFolderPath(
        awsFolderPath: String?
    ): String {
        return BuildConfig.URLS_MAP[BuildConfig.BUCKET_BASE_URL] + awsFolderPath
    }

    /**
     * @param fileName - Name of the file to be uploaded
     * @return awsFolderPath - Generates and returns AWS folder path where file will be uploaded
     */
    fun generateAWSFolderPathFromFileName(
        fileName: String?
    ): String {
        //TODO: use user_unique_id
        val tokenManager = TokenManager.getInstance()
        val userId = tokenManager.memberId
        val fileNameWithoutExtension = fileName?.substringBeforeLast(".")
        val extension = fileName?.substringAfterLast(".", "")
        return "post/$userId/" + fileNameWithoutExtension + "-" + System.currentTimeMillis() + "." + extension
    }

    /**
     * @param uri - ContentUri
     * @return path - full path of the file
     */
    fun getRealPath(context: Context, uri: Uri): String {
        val contentResolver = context.contentResolver
        val pathTempFile = getFullPathTemp(context, uri)
        val file = File(pathTempFile)
        val returnedPath = getPath(context, uri)
        Log.d("PUI", """"
        path temp: $pathTempFile  
          returned: $returnedPath 
        """.trimIndent())
        return when {
            //Third Party App
            returnedPath.isBlank() -> {
                downloadFile(contentResolver, file, uri)
                pathTempFile
            }
            //Unknown Provider or unknown mime type
            uri.isUnknownProvider(returnedPath, contentResolver) -> {
                downloadFile(contentResolver, file, uri)
                pathTempFile
            }
            //LocalFile
            else -> {
                returnedPath
            }
        }
    }

    /**
     *  Method that downloads the file to an internal folder at the root of the project.
     *  For cases where the file has an unknown provider, cloud files and for users using
     *  third-party file explorer api.
     *
     * @param uri of the file
     * @return new path string
     */
    fun downloadFile(
        contentResolver: ContentResolver,
        file: File,
        uri: Uri
    ): Boolean {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            inputStream?.use { input ->
                FileOutputStream(file).use { output ->
                    val buffer = ByteArray(1024)
                    var read: Int = input.read(buffer)
                    while (read != -1) {
                        output.write(buffer, 0, read)
                        read = input.read(buffer)
                    }
                }
            }
        } catch (e: Exception) {
            file.deleteRecursively()
            e.printStackTrace()
            Log.e("TAG", "downloadFile", e)
        }
        return true
    }

    private fun getFullPathTemp(context: Context, uri: Uri): String {
        val folder: File? = context.getExternalFilesDir("Temp")
        return "${folder.toString()}/${getFileName(context, uri)}"
    }

    fun getFileName(context: Context?, fileUri: Uri): String? {
        var fileName: String? = null
        if (fileUri.scheme == ContentResolver.SCHEME_CONTENT) {
            context?.contentResolver?.query(fileUri, null, null, null, null)?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                cursor.moveToFirst()
                fileName = cursor.getString(nameIndex)
            }
        } else if (fileUri.scheme == ContentResolver.SCHEME_FILE) {
            fileName = File(fileUri.path.toString()).name
        } else {
            fileName = fileUri.path
            val cut = fileName?.lastIndexOf('/') ?: -1
            if (cut != -1) fileName = fileName?.substring(cut.plus(1))
        }
        return fileName
    }

    @SuppressLint("NewApi")
    @Suppress("DEPRECATION")
    internal fun getPath(context: Context, uri: Uri): String {
        val contentResolver = context.contentResolver
        //Document Provider
        return when {
            DocumentsContract.isDocumentUri(context, uri) -> {
                when {
                    uri.isExternalStorageDocument -> externalStorageDocument(context, uri)
                    uri.isRawDownloadsDocument -> rawDownloadsDocument(contentResolver, uri)
                    uri.isDownloadsDocument -> downloadsDocument(contentResolver, uri)
                    uri.isMediaDocument -> mediaDocument(contentResolver, uri)
                    else -> {
                        return ""
                    }
                }
            }
            uri.isFile -> uri.path ?: ""
            else -> ""
        }
    }

    /**
     * Method for external document
     *
     */
    @SuppressLint("NewApi")
    @Suppress("DEPRECATION")
    private fun externalStorageDocument(context: Context, uri: Uri): String {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":").toTypedArray()
        val type = split[0]
        if ("primary".equals(type, ignoreCase = true)) {
            return if (split.size > 1) {
                "${Environment.getExternalStorageDirectory()}/${split[1]}"
            } else {
                "${Environment.getExternalStorageDirectory()}/"
            }
        } else {
            val path = "storage/${docId.replace(":", "/")}"
            if (File(path).exists()) {
                return "/$path"
            }
            val availableExternalStorage = getStorageDirectories(context)
            var root = ""
            availableExternalStorage.forEach { storage ->
                root = if (split[1].startsWith("/")) {
                    "$storage${split[1]}"
                } else {
                    "$storage/${split[1]}"
                }
            }
            return if (root.contains(type)) {
                path
            } else {
                if (root.startsWith("/storage/") || root.startsWith("storage/")) {
                    root
                } else if (root.startsWith("/")) {
                    "/storage$root"
                } else {
                    "/storage/$root"
                }
            }
        }
    }

    /**
     * Method for rawDownloadDocument
     *
     */
    @Suppress("DEPRECATION")
    @SuppressLint("NewApi")
    private fun rawDownloadsDocument(contentResolver: ContentResolver, uri: Uri): String {
        val fileName = getPathFromColumn(contentResolver, uri, COLUMN_DISPLAY_NAME)
        val subFolderName = getSubFolders(uri.toString())
        return if (fileName.isNotBlank()) {
            "${Environment.getExternalStorageDirectory()}/$FOLDER_DOWNLOAD/$subFolderName$fileName"
        } else {
            val id = DocumentsContract.getDocumentId(uri)
            val contentUri = ContentUris.withAppendedId(
                Uri.parse("content://downloads/public_downloads"),
                id.toLong()
            )
            getPathFromColumn(contentResolver, contentUri, COLUMN_DATA)
        }
    }


    /**
     * Method for downloadsDocument
     *
     */
    @SuppressLint("NewApi")
    @Suppress("DEPRECATION")
    private fun downloadsDocument(contentResolver: ContentResolver, uri: Uri): String {
        val fileName = getPathFromColumn(contentResolver, uri, COLUMN_DISPLAY_NAME)
        val subFolderName = getSubFolders(uri.toString())
        if (fileName.isNotBlank()) {
            return "${Environment.getExternalStorageDirectory()}/$FOLDER_DOWNLOAD/$subFolderName$fileName"
        }
        var id = DocumentsContract.getDocumentId(uri)
        if (id.startsWith("raw:")) {
            id = id.replaceFirst("raw:".toRegex(), "")
            val file = File(id)
            if (file.exists()) return id
        } else if (id.startsWith("raw%3A%2F")) {
            id = id.replaceFirst("raw%3A%2F".toRegex(), "")
            val file = File(id)
            if (file.exists()) return id
        }
        val contentUri = ContentUris.withAppendedId(
            Uri.parse("content://downloads/public_downloads"),
            id.toLong()
        )
        return getPathFromColumn(contentResolver, contentUri, COLUMN_DATA)
    }


    /**
     * Returns subfolder from the main folder to the file location or empty string
     * EXAMPLE:
     * Input uriString = "content://com.android.providers.downloads.documents/document/raw%3%2Fstorage%2Femulated%2F0%2FDownload%2FsubFolder%2FsubFolder2%2Ffile.jpg"
     * Input folderRoot = "Download"
     * Output: subFolder/subFolder2/
     *
     * @param uriString Path file
     * @param folderRoot It is usually "Download"
     */
    fun getSubFolders(uriString: String, folderRoot: String = FOLDER_DOWNLOAD) =
        uriString
            .replace("%2F", "/")
            .replace("%20", " ")
            .replace("%3A", ":")
            .split("/")
            .run {
                val indexRoot = indexOf(folderRoot)
                if (folderRoot.isNotBlank().and(indexRoot != -1)) {
                    subList(indexRoot + 1, lastIndex)
                        .joinToString(separator = "") { "$it/" }
                } else {
                    ""
                }
            }

    /**
     * Method for MediaDocument
     *
     */
    @SuppressLint("NewApi")
    private fun mediaDocument(contentResolver: ContentResolver, uri: Uri): String {
        val docId = DocumentsContract.getDocumentId(uri)
        val split: Array<String?> = docId.split(":").toTypedArray()
        val contentUri: Uri =
            when (split[0]) {
                "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                //Todo test
                else -> MediaStore.Files.getContentUri(docId)
            }
        val selection = "_id=?"
        val selectionArgs = arrayOf(split[1])
        return getPathFromColumn(
            contentResolver,
            contentUri,
            COLUMN_DATA,
            selection,
            selectionArgs
        )
    }
}