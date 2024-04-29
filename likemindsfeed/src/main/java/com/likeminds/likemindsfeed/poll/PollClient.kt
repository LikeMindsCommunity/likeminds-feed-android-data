package com.likeminds.likemindsfeed.poll

import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class PollClient @Inject constructor() : BaseClient() {
    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().pollComponent()?.inject(this)
    }

    private val pollApi by lazy {
        feedSDK.getPollApi()
    }
}