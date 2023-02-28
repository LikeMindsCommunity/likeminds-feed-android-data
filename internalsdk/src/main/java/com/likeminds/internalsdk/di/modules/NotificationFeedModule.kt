package com.likeminds.internalsdk.di.modules

import com.google.gson.Gson
import com.likeminds.internalsdk.notificationfeed.NotificationFeedNetworkApi
import com.likeminds.internalsdk.utils.retrofit.NetworkResponseAdapterFactory
import com.likeminds.internalsdk.utils.retrofit.model.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NotificationFeedModule {

    @Provides
    @Singleton
    fun provideNotificationFeedModule(
        client: OkHttpClient,
        gson: Gson,
        baseUrl: BaseUrl
    ): NotificationFeedNetworkApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl.getKettleBase())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory(gson))
            .build()
            .create(NotificationFeedNetworkApi::class.java)
    }
}