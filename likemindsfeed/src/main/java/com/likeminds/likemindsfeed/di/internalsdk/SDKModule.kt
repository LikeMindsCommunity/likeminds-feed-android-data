package com.likeminds.likemindsfeed.di.internalsdk

import com.google.gson.Gson
import com.likeminds.internalsdk.FeedSDK
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class SDKModule {

    @Provides
    @Singleton
    fun provideInternalSDK(): FeedSDK {
        return FeedSDK.getInstance()
    }

    @Provides
    @Singleton
    fun provideGson(feedSDK: FeedSDK): Gson {
        return feedSDK.gson
    }
}