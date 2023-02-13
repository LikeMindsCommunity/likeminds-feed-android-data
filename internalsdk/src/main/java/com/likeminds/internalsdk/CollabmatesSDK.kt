package com.likeminds.internalsdk

import android.app.Application
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.google.gson.Gson
import com.likeminds.internalsdk.di.DaggerSDKComponent
import com.likeminds.internalsdk.di.SDKComponent
import com.likeminds.internalsdk.di.SDKSharedResources
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CollabmatesSDK private constructor() {
    private var sdkComponent: SDKComponent? = null

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var gson: Gson

    companion object {
        private var collabmatesSDKInstance: CollabmatesSDK? = null

        @JvmStatic
        fun getInstance(): CollabmatesSDK {
            if (collabmatesSDKInstance == null) {
                collabmatesSDKInstance = CollabmatesSDK()
            }
            return collabmatesSDKInstance!!
        }
    }

    fun initialize(sdkSharedResources: SDKSharedResources) {
        initSDKComponent(sdkSharedResources)
        initAWSMobileClient()
    }

    private fun initSDKComponent(sdkSharedResources: SDKSharedResources) {
        if (sdkComponent == null) {
            sdkComponent = DaggerSDKComponent.builder()
                .sdkSharedResources(sdkSharedResources)
                .build()
            sdkComponent?.inject(this)
        }
    }

    private fun initAWSMobileClient() {
        AWSMobileClient.getInstance().initialize(application, object : Callback<UserStateDetails> {
            override fun onResult(result: UserStateDetails?) {
            }

            override fun onError(e: java.lang.Exception?) {
            }
        })
    }
}