package com.likeminds.likemindsfeed.sdk

import android.app.Application
import android.util.Log
import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.LMInternalCallback
import com.likeminds.internalsdk.di.LMFeedSDKSharedResources
import com.likeminds.likemindsfeed.LMFeedSDKCallback
import com.likeminds.likemindsfeed.di.DaggerLikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.LikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.comment.CommentSubComponent
import com.likeminds.likemindsfeed.di.configuration.ConfigurationSubComponent
import com.likeminds.likemindsfeed.di.helper.HelperSubComponent
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserSubComponent
import com.likeminds.likemindsfeed.di.moderation.ModerationSubComponent
import com.likeminds.likemindsfeed.di.notificationfeed.NotificationFeedSubComponent
import com.likeminds.likemindsfeed.di.poll.PollSubComponent
import com.likeminds.likemindsfeed.di.post.PostSubComponent
import com.likeminds.likemindsfeed.di.topic.TopicSubComponent
import com.likeminds.likemindsfeed.di.universalfeed.UniversalFeedSubComponent
import javax.inject.Inject

internal class LikeMindsFeedApplication private constructor() : LMInternalCallback {

    @Inject
    lateinit var feedSDK: FeedSDK

    @Inject
    lateinit var lmFeedSDKSharedResources: LMFeedSDKSharedResources

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
    private var pollSubComponent: PollSubComponent? = null

    companion object {
        private var likeMindsFeedApplicationInstance: LikeMindsFeedApplication? = null
        private var lmFeedSDKCallback: LMFeedSDKCallback? = null

        @JvmStatic
        fun getInstance(): LikeMindsFeedApplication {
            if (likeMindsFeedApplicationInstance == null) {
                likeMindsFeedApplicationInstance = LikeMindsFeedApplication()
            }
            return likeMindsFeedApplicationInstance!!
        }
    }

    fun initSDKApplication(application: Application, lmFeedSDKCallback: LMFeedSDKCallback?) {
        likeMindsFeedApplicationInstance = this
        LikeMindsFeedApplication.lmFeedSDKCallback = lmFeedSDKCallback

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

    fun pollComponent(): PollSubComponent? {
        if (pollSubComponent == null) {
            pollSubComponent = likeMindsFeedComponent?.pollComponent()?.create()
        }

        return pollSubComponent
    }

    override fun login() {
        lmFeedSDKCallback?.login()
    }

    override fun onAccessTokenExpiredAndRefreshed(accessToken: String, refreshToken: String) {
        Log.d("PUI","""
            Data Layer Callback -> onAccessTokenExpiredAndRefreshed
            accessToken: $accessToken
            refreshToken: $refreshToken
        """.trimIndent())
        lmFeedSDKCallback?.onAccessTokenExpiredAndRefreshed(accessToken, refreshToken)
    }

    override fun onRefreshTokenExpired(): Pair<String?, String?> {
        return lmFeedSDKCallback?.onRefreshTokenExpired() ?: Pair(null, null)
    }
}