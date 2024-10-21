package com.likeminds.internalsdk.di

import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.di.modules.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LMFeedSDKSharedResourcesModule::class,
        GsonModule::class,
        NetworkModule::class,
        LMFeedSDKModule::class,
        UniversalFeedModule::class,
        CommentModule::class,
        PostModule::class,
        ModerationModule::class,
        HelperModule::class,
        NotificationFeedModule::class,
        TopicModule::class,
        ConfigurationModule::class,
        RoomModule::class,
        PollModule::class,
        SearchModule::class
    ]
)
interface LMFeedSDKComponent {
    fun inject(feedSDK: FeedSDK)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun sdkSharedResources(lmFeedSDKSharedResources: LMFeedSDKSharedResources): Builder

        fun build(): LMFeedSDKComponent
    }
}