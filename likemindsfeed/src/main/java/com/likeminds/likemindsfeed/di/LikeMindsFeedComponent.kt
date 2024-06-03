package com.likeminds.likemindsfeed.di

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.di.comment.CommentModule
import com.likeminds.likemindsfeed.di.comment.CommentSubComponent
import com.likeminds.likemindsfeed.di.configuration.ConfigurationModule
import com.likeminds.likemindsfeed.di.configuration.ConfigurationSubComponent
import com.likeminds.likemindsfeed.di.helper.HelperModule
import com.likeminds.likemindsfeed.di.helper.HelperSubComponent
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserModule
import com.likeminds.likemindsfeed.di.initiateUser.InitiateUserSubComponent
import com.likeminds.likemindsfeed.di.internalsdk.SDKModule
import com.likeminds.likemindsfeed.di.internalsdk.SharedModule
import com.likeminds.likemindsfeed.di.moderation.ModerationModule
import com.likeminds.likemindsfeed.di.moderation.ModerationSubComponent
import com.likeminds.likemindsfeed.di.notificationfeed.NotificationFeedModule
import com.likeminds.likemindsfeed.di.notificationfeed.NotificationFeedSubComponent
import com.likeminds.likemindsfeed.di.poll.PollModule
import com.likeminds.likemindsfeed.di.poll.PollSubComponent
import com.likeminds.likemindsfeed.di.post.PostModule
import com.likeminds.likemindsfeed.di.post.PostSubComponent
import com.likeminds.likemindsfeed.di.topic.TopicModule
import com.likeminds.likemindsfeed.di.topic.TopicSubComponent
import com.likeminds.likemindsfeed.di.universalfeed.UniversalFeedModule
import com.likeminds.likemindsfeed.di.universalfeed.UniversalFeedSubComponent
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SharedModule::class,
        SDKModule::class,
        InitiateUserModule::class,
        UniversalFeedModule::class,
        CommentModule::class,
        PostModule::class,
        ModerationModule::class,
        HelperModule::class,
        NotificationFeedModule::class,
        TopicModule::class,
        ConfigurationModule::class,
        PollModule::class
    ]
)
internal interface LikeMindsFeedComponent {

    fun inject(likeMindsFeedApplication: LikeMindsFeedApplication)
    fun inject(lmFeedClient: LMFeedClient)

    fun initiateUserComponent(): InitiateUserSubComponent.Factory
    fun universalFeedComponent(): UniversalFeedSubComponent.Factory
    fun commentComponent(): CommentSubComponent.Factory
    fun postComponent(): PostSubComponent.Factory
    fun moderationComponent(): ModerationSubComponent.Factory
    fun helperComponent(): HelperSubComponent.Factory
    fun notificationFeedComponent(): NotificationFeedSubComponent.Factory
    fun topicComponent(): TopicSubComponent.Factory
    fun configurationComponent(): ConfigurationSubComponent.Factory
    fun pollComponent(): PollSubComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LikeMindsFeedComponent
    }
}