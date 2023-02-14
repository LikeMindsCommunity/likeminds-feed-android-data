package com.likeminds.internalsdk.di.modules

import com.google.gson.Gson
import com.likeminds.internalsdk.TokenManager
import com.likeminds.internalsdk.sdk.SDKNetworkApi
import com.likeminds.internalsdk.utils.retrofit.NetworkResponseAdapterFactory
import com.likeminds.internalsdk.utils.retrofit.model.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class SDKModule {

    @Provides
    @Singleton
    fun provideTokenManager(): TokenManager {
        return TokenManager.getInstance()
    }

    @Provides
    @Singleton
    fun provideSDKModule(
        client:OkHttpClient,
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

}