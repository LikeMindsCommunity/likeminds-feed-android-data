package com.likeminds.internalsdk.di

import com.likeminds.internalsdk.CollabmatesSDK
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
        AWSModule::class,
        BrandingModule::class,
        UniversalFeedModule::class,
        PostModule::class,
        ModerationModule::class
    ]
)
interface SDKComponent {
    fun inject(collabmatesSDK: CollabmatesSDK)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun sdkSharedResources(sdkSharedResources: SDKSharedResources): Builder

        fun build(): SDKComponent
    }
}