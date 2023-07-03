package com.likeminds.likemindsfeed.base

import com.likeminds.internalsdk.CollabmatesSDK
import javax.inject.Inject

abstract class BaseClient {

    init {
        attachDagger()
    }

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    protected abstract fun attachDagger()
}