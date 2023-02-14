package com.likeminds.internalsdk.di

import com.likeminds.internalsdk.CollabmatesSDK
import com.likeminds.internalsdk.di.modules.GsonModule
import com.likeminds.internalsdk.di.modules.NetworkModule
import com.likeminds.internalsdk.di.modules.SDKModule
import com.likeminds.internalsdk.di.modules.SDKSharedResourcesModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SDKSharedResourcesModule::class, GsonModule::class, NetworkModule::class, SDKModule::class])
interface SDKComponent {
    fun inject(collabmatesSDK: CollabmatesSDK)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun sdkSharedResources(sdkSharedResources: SDKSharedResources): Builder

        fun build(): SDKComponent
    }
}