package com.likeminds.likemindsfeed.di.internalsdk

import com.likeminds.internalsdk.di.LMFeedSDKSharedResources
import com.likeminds.likemindsfeed.sdk.utils.LMFeedSDKSharedResourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class SharedModule {

    @Provides
    @Singleton
    fun providesSDKSharedResource(sdkSharedResources: LMFeedSDKSharedResourceImpl): LMFeedSDKSharedResources {
        return sdkSharedResources
    }
}