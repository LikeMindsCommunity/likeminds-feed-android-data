package com.likeminds.internalsdk.di.modules

import com.google.gson.Gson
import com.likeminds.internalsdk.FeedTokenManager
import com.likeminds.internalsdk.sdk.*
import com.likeminds.internalsdk.utils.retrofit.NetworkResponseAdapterFactory
import com.likeminds.internalsdk.utils.retrofit.model.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class LMFeedSDKModule {

    @Provides
    @Singleton
    fun provideFeedTokenManager(): FeedTokenManager {
        return FeedTokenManager.getInstance()
    }

    @Provides
    @Singleton
    fun provideSDKModule(
        client: OkHttpClient,
        gson: Gson,
        baseUrl: BaseUrl
    ): SDKNetworkApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl.getKettleBase())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory(gson))
            .build()
            .create(SDKNetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRefreshTokenApi(
        client: OkHttpClient,
        gson: Gson,
        baseUrl: BaseUrl
    ): RefreshTokenNetworkApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl.getKettleBase())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory(gson))
            .build()
            .create(RefreshTokenNetworkApi::class.java)
    }
}