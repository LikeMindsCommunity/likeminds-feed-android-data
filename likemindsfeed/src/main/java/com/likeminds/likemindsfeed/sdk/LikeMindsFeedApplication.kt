package com.likeminds.likemindsfeed.sdk

import android.app.Application
import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.LMInternalCallback
import com.likeminds.internalsdk.di.LMFeedSDKSharedResources
import com.likeminds.internalsdk.sdk.SDKPreferences
import com.likeminds.likemindsfeed.LMCallback
import com.likeminds.likemindsfeed.di.DaggerLikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.LikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.comment.CommentSubComponent
import com.likeminds.likemindsfeed.di.configuration.ConfigurationSubComponent
import com.likeminds.likemindsfeed.di.helper.HelperSubComponent
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserSubComponent
import com.likeminds.likemindsfeed.di.moderation.ModerationSubComponent
import com.likeminds.likemindsfeed.di.notificationfeed.NotificationFeedSubComponent
import com.likeminds.likemindsfeed.di.post.PostSubComponent
import com.likeminds.likemindsfeed.di.topic.TopicSubComponent
import com.likeminds.likemindsfeed.di.universalfeed.UniversalFeedSubComponent
import javax.inject.Inject

internal class LikeMindsFeedApplication private constructor() : LMInternalCallback {

    @Inject
    lateinit var feedSDK: FeedSDK

    @Inject
    lateinit var lmFeedSDKSharedResources: LMFeedSDKSharedResources

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    var likeMindsFeedComponent: LikeMindsFeedComponent? = null

    private var initiateUserComponent: InitiateUserSubComponent? = null
    private var commentComponent: CommentSubComponent? = null
    private var universalFeedComponent: UniversalFeedSubComponent? = null
    private var postComponent: PostSubComponent? = null
    private var moderationComponent: ModerationSubComponent? = null
    private var helperComponent: HelperSubComponent? = null
    private var notificationFeedComponent: NotificationFeedSubComponent? = null
    private var topicSubComponent: TopicSubComponent? = null
    private var configurationSubComponent: ConfigurationSubComponent? = null

    companion object {
        private var likeMindsFeedApplicationInstance: LikeMindsFeedApplication? = null
        private var lmCallback: LMCallback? = null

        @JvmStatic
        fun getInstance(): LikeMindsFeedApplication {
            if (likeMindsFeedApplicationInstance == null) {
                likeMindsFeedApplicationInstance = LikeMindsFeedApplication()
            }
            return likeMindsFeedApplicationInstance!!
        }
    }

    fun initSDKApplication(application: Application, lmCallback: LMCallback?) {
        likeMindsFeedApplicationInstance = this
        LikeMindsFeedApplication.lmCallback = lmCallback

        //init dagger
        initLikeMindsFeedComponent(application)
        feedSDK.initialize(lmFeedSDKSharedResources, this)
    }

    private fun initLikeMindsFeedComponent(application: Application) {
        if (likeMindsFeedComponent == null) {
            likeMindsFeedComponent = DaggerLikeMindsFeedComponent.builder()
                .application(application)
                .build()
        }
        likeMindsFeedComponent?.inject(this)
    }

    fun initiateUserComponent(): InitiateUserSubComponent? {
        if (initiateUserComponent == null) {
            initiateUserComponent = likeMindsFeedComponent?.initiateUserComponent()?.create()
        }
        return initiateUserComponent
    }

    fun universalFeedComponent(): UniversalFeedSubComponent? {
        if (universalFeedComponent == null) {
            universalFeedComponent = likeMindsFeedComponent?.universalFeedComponent()?.create()
        }
        return universalFeedComponent
    }

    fun postComponent(): PostSubComponent? {
        if (postComponent == null) {
            postComponent = likeMindsFeedComponent?.postComponent()?.create()
        }
        return postComponent
    }

    fun moderationComponent(): ModerationSubComponent? {
        if (moderationComponent == null) {
            moderationComponent = likeMindsFeedComponent?.moderationComponent()?.create()
        }
        return moderationComponent
    }

    fun commentComponent(): CommentSubComponent? {
        if (commentComponent == null) {
            commentComponent = likeMindsFeedComponent?.commentComponent()?.create()
        }
        return commentComponent
    }

    fun helperComponent(): HelperSubComponent? {
        if (helperComponent == null) {
            helperComponent = likeMindsFeedComponent?.helperComponent()?.create()
        }
        return helperComponent
    }

    fun notificationFeedComponent(): NotificationFeedSubComponent? {
        if (notificationFeedComponent == null) {
            notificationFeedComponent =
                likeMindsFeedComponent?.notificationFeedComponent()?.create()
        }
        return notificationFeedComponent
    }

    fun topicComponent(): TopicSubComponent? {
        if (topicSubComponent == null) {
            topicSubComponent = likeMindsFeedComponent?.topicComponent()?.create()
        }

        return topicSubComponent
    }

    fun configurationComponent(): ConfigurationSubComponent? {
        if (configurationSubComponent == null) {
            configurationSubComponent = likeMindsFeedComponent?.configurationComponent()?.create()
        }

        return configurationSubComponent
    }

    override fun login() {
        lmCallback?.login()
    }
}