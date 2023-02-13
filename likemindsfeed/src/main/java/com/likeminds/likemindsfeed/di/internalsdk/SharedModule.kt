package com.likeminds.likemindsfeed.di.internalsdk

import com.likeminds.internalsdk.di.SDKSharedResources
import com.likeminds.likemindsfeed.sdk.utils.SDKSharedResourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class SharedModule {

    @Provides
    @Singleton
    fun providesSDKSharedResource(sdkSharedResources: SDKSharedResourceImpl): SDKSharedResources {
        return sdkSharedResources
    }
}