package com.likeminds.likemindsfeed.di.internalsdk

import com.likeminds.internalsdk.di.SDKSharedResources
import com.likeminds.internalsdk.di.modules.AWSModule
import com.likeminds.likemindsfeed.sdk.utils.SDKSharedResourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AWSModule::class])
internal class SharedModule {

    @Provides
    @Singleton
    fun providesSDKSharedResource(sdkSharedResources: SDKSharedResourceImpl): SDKSharedResources {
        return sdkSharedResources
    }
}