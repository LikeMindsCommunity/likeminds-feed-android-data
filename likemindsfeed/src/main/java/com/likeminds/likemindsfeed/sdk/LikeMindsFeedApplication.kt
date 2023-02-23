package com.likeminds.likemindsfeed.sdk

import android.app.Application
import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.di.SDKSharedResources
import com.likeminds.likemindsfeed.di.DaggerLikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.LikeMindsFeedComponent
import com.likeminds.likemindsfeed.di.branding.BrandingSubComponent
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserSubComponent
import com.likeminds.likemindsfeed.di.moderation.ModerationSubComponent
import com.likeminds.likemindsfeed.di.post.PostSubComponent
import com.likeminds.likemindsfeed.di.universalfeed.UniversalFeedSubComponent
import com.likeminds.likemindsfeed.sdk.model.InitiateLikeMindsExtra
import com.likeminds.likemindsfeed.sdk.utils.SDKPreferences
import javax.inject.Inject

internal class LikeMindsFeedApplication private constructor() {

    @Inject
    lateinit var collabmatesSDK: CollabmatesSDK

    @Inject
    lateinit var sdkSharedResources: SDKSharedResources

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    var likeMindsFeedComponent: LikeMindsFeedComponent? = null

    private var initiateUserSubComponent: InitiateUserSubComponent? = null
    private var brandingComponent: BrandingSubComponent? = null
    private var universalFeedComponent: UniversalFeedSubComponent? = null
    private var postComponent: PostSubComponent? = null
    private var moderationComponent: ModerationSubComponent? = null

    companion object {
        private var likeMindsFeedApplicationInstance: LikeMindsFeedApplication? = null

        @JvmStatic
        fun getInstance(): LikeMindsFeedApplication {
            if (likeMindsFeedApplicationInstance == null) {
                likeMindsFeedApplicationInstance = LikeMindsFeedApplication()
            }
            return likeMindsFeedApplicationInstance!!
        }
    }

    fun initSDKApplication(extra: InitiateLikeMindsExtra) {
        likeMindsFeedApplicationInstance = this

        //init dagger
        initLikeMindsFeedComponent(extra.application)
        collabmatesSDK.initialize(sdkSharedResources)

        //save extras
        saveExtrasInPreferences(extra)
    }

    private fun initLikeMindsFeedComponent(application: Application) {
        if (likeMindsFeedComponent == null) {
            likeMindsFeedComponent = DaggerLikeMindsFeedComponent.builder()
                .application(application)
                .build()
        }
        likeMindsFeedComponent?.inject(this)
    }

    private fun saveExtrasInPreferences(extra: InitiateLikeMindsExtra) {
        sdkPreferences.setAPIKey(extra.apiKey)
        sdkPreferences.setNotificationIcon(extra.notificationIcon ?: 0)
        sdkPreferences.setDomain(extra.domain)
    }

    fun initiateUserComponent(): InitiateUserSubComponent? {
        if (initiateUserSubComponent == null) {
            initiateUserSubComponent = likeMindsFeedComponent?.initiateUserComponent()?.create()
        }
        return initiateUserSubComponent
    }

    fun brandingComponent(): BrandingSubComponent? {
        if (brandingComponent == null) {
            brandingComponent = likeMindsFeedComponent?.brandingComponent()?.create()
        }
        return brandingComponent
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
}