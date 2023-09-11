package com.likeminds.likemindsfeed.base

import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.sdk.SDKPreferences
import javax.inject.Inject

abstract class BaseClient {

    init {
        attachDagger()
    }

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    @Inject
    lateinit var feedSDK: FeedSDK

    protected abstract fun attachDagger()
}