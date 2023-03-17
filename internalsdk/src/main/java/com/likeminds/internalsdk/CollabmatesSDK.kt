package com.likeminds.internalsdk

import android.app.Application
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.google.gson.Gson
import com.likeminds.internalsdk.comment.CommentApi
import com.likeminds.internalsdk.comment.CommentApiImpl
import com.likeminds.internalsdk.di.DaggerSDKComponent
import com.likeminds.internalsdk.di.SDKComponent
import com.likeminds.internalsdk.di.SDKSharedResources
import com.likeminds.internalsdk.moderation.ModerationApi
import com.likeminds.internalsdk.moderation.ModerationApiImpl
import com.likeminds.internalsdk.post.PostApi
import com.likeminds.internalsdk.post.PostApiImpl
import com.likeminds.internalsdk.sdk.RefreshTokenApiImpl
import com.likeminds.internalsdk.sdk.SDKApi
import com.likeminds.internalsdk.sdk.SDKApiImpl
import com.likeminds.internalsdk.universalfeed.UniversalFeedApi
import com.likeminds.internalsdk.universalfeed.UniversalFeedApiImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CollabmatesSDK {
    private var sdkComponent: SDKComponent? = null

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var sdkApiImpl: SDKApiImpl

    @Inject
    lateinit var universalFeedApiImpl: UniversalFeedApiImpl

    @Inject
    lateinit var postApiImpl: PostApiImpl

    @Inject
    lateinit var refreshTokenApiImpl: RefreshTokenApiImpl

    @Inject
    lateinit var commentApiImpl: CommentApiImpl

    @Inject
    lateinit var moderationApiImpl: ModerationApiImpl

    companion object {
        private var collabmatesSDKInstance: CollabmatesSDK? = null
        const val LOG_TAG = "LikeMinds"

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

    fun getSDKApi(): SDKApi {
        return sdkApiImpl
    }

    fun getUniversalFeedApi(): UniversalFeedApi {
        return universalFeedApiImpl
    }

    fun getCommentApi(): CommentApi {
        return commentApiImpl
    }

    fun getPostApi(): PostApi {
        return postApiImpl
    }

    fun getModerationApi(): ModerationApi {
        return moderationApiImpl
    }
}