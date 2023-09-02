package com.likeminds.likemindsfeed.community

import com.likeminds.likemindsfeed.base.BaseClient
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import javax.inject.Inject

class CommunityClient @Inject constructor() : BaseClient() {

    override fun attachDagger() {
        LikeMindsFeedApplication.getInstance().communityComponent()?.inject(this)
    }

    private val communityApi by lazy {
        collabmatesSDK.getCommunityApi()
    }

    companion object {
        @JvmStatic
        private var communityClient: CommunityClient? = null

        fun getInstance(): CommunityClient {
            if (communityClient == null) {
                communityClient = CommunityClient()
            }
            return communityClient!!
        }
    }
}