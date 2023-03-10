package com.likeminds.internalsdk.utils.mediauploader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.exifinterface.media.ExifInterface
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object FileHelper {

    private const val TAG = "FileHelper"

    fun compressFile(applicationContext: Context, filePath: String): File? {
        try {
            val oldExifOrientation =
                ExifInterface(filePath).getAttribute(ExifInterface.TAG_ORIENTATION)
            Log.d(TAG, "compressFile: 1")
            val bitmap = BitmapFactory.decodeFile(filePath) ?: return null
            Log.d(TAG, "compressFile: 2")
            val imagesFolder = File(applicationContext.cacheDir, "images")
            imagesFolder.mkdirs()
            val file = File(imagesFolder, "${System.currentTimeMillis()}.png")
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream)
            stream.flush()
            stream.close()
            // Update the old image orientation attributes to the compressed one
            if (oldExifOrientation != null) {
                val newExif = ExifInterface(file.absolutePath)
                newExif.setAttribute(ExifInterface.TAG_ORIENTATION, oldExifOrientation)
                newExif.saveAttributes()
            }
            Log.d(TAG, "compressFile: compressed")
            return file
        } catch (e: IOException) {
            Log.d(TAG, "compressFile: error")
            Log.e(
                TAG,
                "IOException while trying to compress file: " + e.localizedMessage
            )
            return null
        }
    }
}