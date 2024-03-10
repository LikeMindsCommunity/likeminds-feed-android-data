package com.likeminds.likemindsfeed.sdk.utils

import android.app.Application
import com.likeminds.internalsdk.di.LMFeedSDKSharedResources
import javax.inject.Inject

internal class LMFeedSDKSharedResourceImpl @Inject constructor(private val application: Application) :
    LMFeedSDKSharedResources {
    override fun getApplication(): Application {
        return application
    }
}