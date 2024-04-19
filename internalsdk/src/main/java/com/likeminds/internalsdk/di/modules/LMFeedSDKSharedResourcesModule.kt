package com.likeminds.internalsdk.di.modules

import android.app.Application
import android.content.Context
import com.likeminds.internalsdk.di.LMFeedSDKSharedResources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LMFeedSDKSharedResourcesModule {
    @Provides
    @Singleton
    fun provideApplication(lmFeedSDKSharedResources: LMFeedSDKSharedResources): Application {
        return lmFeedSDKSharedResources.getApplication()
    }

    @Provides
    @Singleton
    fun provideContext(lmFeedSDKSharedResources: LMFeedSDKSharedResources): Context {
        return lmFeedSDKSharedResources.getApplication()
    }

}