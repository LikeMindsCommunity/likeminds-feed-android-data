package com.likeminds.internalsdk.di

import com.likeminds.internalsdk.FeedSDK
import com.likeminds.internalsdk.di.modules.CommentModule
import com.likeminds.internalsdk.di.modules.GsonModule
import com.likeminds.internalsdk.di.modules.HelperModule
import com.likeminds.internalsdk.di.modules.ModerationModule
import com.likeminds.internalsdk.di.modules.NetworkModule
import com.likeminds.internalsdk.di.modules.NotificationFeedModule
import com.likeminds.internalsdk.di.modules.PostModule
import com.likeminds.internalsdk.di.modules.SDKModule
import com.likeminds.internalsdk.di.modules.SDKSharedResourcesModule
import com.likeminds.internalsdk.di.modules.TopicModule
import com.likeminds.internalsdk.di.modules.UniversalFeedModule
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
        TopicModule::class
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