package com.likeminds.likemindsfeed.base

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.sdk.SDKPreferences
import javax.inject.Inject

abstract class BaseClient {

    init {
        attachDagger()
    }

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    protected abstract fun attachDagger()
}