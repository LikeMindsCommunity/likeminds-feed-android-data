package com.likeminds.likemindsfeed

import android.app.Application
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.di.SDKSharedResources
import com.likeminds.likemindsfeed.di.DaggerLikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.LikeMindsFeedComponent
import javax.inject.Inject

internal class SDKApplication private constructor() {

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    @Inject
    lateinit var sdkSharedResources: SDKSharedResources

    private var likeMindsFeedComponent: LikeMindsFeedComponent? = null

    companion object {
        private var sdkApplicationInstance: SDKApplication? = null

        @JvmStatic
        fun getInstance(): SDKApplication {
            if (sdkApplicationInstance == null) {
                sdkApplicationInstance = SDKApplication()
            }
            return sdkApplicationInstance!!
        }
    }

    fun initSDKApplication(extra: InitiateLikeMindsExtra) {
        sdkApplicationInstance = this
        initLikeMindsFeedComponent(extra.application)
        collabmatesSDK.initialize(sdkSharedResources)
    }

    private fun initLikeMindsFeedComponent(application: Application) {
        if (likeMindsFeedComponent == null) {
            likeMindsFeedComponent = DaggerLikeMindsFeedComponent.builder()
                .application(application)
                .build()
        }
        likeMindsFeedComponent?.inject(this)
    }
}