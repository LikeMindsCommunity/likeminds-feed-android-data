package com.likeminds.internalsdk.utils

import android.util.Log
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.likeminds.internalsdk.BuildConfig
import java.io.File
import javax.inject.Inject

class Storage @Inject constructor(private val transferUtility: TransferUtility) {

    companion object {
        private const val TAG = "StorageObject"
    }

    fun upload(
        file: File?,
        path: String,
        callback: (error: String?, link: String?) -> Unit,
    ) {
        if (file == null) {
            callback("File not found", null)
            return
        }
        val transferObserver =
            transferUtility.upload(path, file, CannedAccessControlList.PublicRead)

        transferObserver.setTransferListener(object : TransferListener {
            override fun onStateChanged(id: Int, state: TransferState?) {
                when (state) {
                    TransferState.COMPLETED -> {
                        Log.i(TAG, "File uploaded")
                        val downloadUri =
                            "${BuildConfig.URLS_MAP[BuildConfig.BUCKET_BASE_URL]}${path}"
                        callback(null, downloadUri)
                    }
                    TransferState.FAILED -> {
                        Log.i(TAG, "File upload failed")
                        callback("Transfer State Failed", null)
                    }
                    else -> {
                        Log.i(TAG, "$state File Uploading")
                    }
                }
            }

            override fun onProgressChanged(id: Int, bytesCurrent: Long, bytesTotal: Long) {
                Log.i(TAG, "$bytesCurrent $bytesTotal")
            }

            override fun onError(id: Int, ex: Exception?) {
                Log.e(TAG, "Upload Failed ${ex?.stackTrace}")
                callback(ex?.message, null)
            }

        })
    }
}