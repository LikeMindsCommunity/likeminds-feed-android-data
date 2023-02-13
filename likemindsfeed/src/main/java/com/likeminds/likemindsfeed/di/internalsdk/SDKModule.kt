package com.likeminds.likemindsfeed.di.internalsdk

import com.google.gson.Gson
import com.likeminds.internalsdk.CollabmatesSDK
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class SDKModule {

    @Provides
    @Singleton
    fun provideInternalSDK(): CollabmatesSDK {
        return CollabmatesSDK.getInstance()
    }

    @Provides
    @Singleton
    fun provideGson(collabmatesSDK: CollabmatesSDK): Gson {
        return collabmatesSDK.gson
    }
}