package com.likeminds.likemindsfeed.base

import com.likeminds.internalsdk.FeedSDK
import javax.inject.Inject

abstract class BaseClient {

    init {
        attachDagger()
    }

    @Inject
    lateinit var feedSDK: FeedSDK

    protected abstract fun attachDagger()
}