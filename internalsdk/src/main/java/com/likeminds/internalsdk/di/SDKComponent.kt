package com.likeminds.internalsdk.di

import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.di.modules.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SDKSharedResourcesModule::class,
        GsonModule::class,
        NetworkModule::class,
        SDKModule::class,
        UniversalFeedModule::class,
        CommentModule::class,
        PostModule::class,
        ModerationModule::class,
        HelperModule::class,
        NotificationFeedModule::class,
        TopicModule::class,
        ConfigurationModule::class
    ]
)
interface SDKComponent {
    fun inject(feedSDK: FeedSDK)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun sdkSharedResources(sdkSharedResources: SDKSharedResources): Builder

        fun build(): SDKComponent
    }
}