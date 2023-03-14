package com.likeminds.internalsdk.di.modules

import com.google.gson.Gson
import com.likeminds.internalsdk.TokenManager
import com.likeminds.internalsdk.branding.BrandingNetworkApi
import com.likeminds.internalsdk.utils.retrofit.NetworkResponseAdapterFactory
import com.likeminds.internalsdk.utils.retrofit.model.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class BrandingModule {

    //TODO: TO be shifted to Kettle
    @Provides
    @Singleton
    fun provideBrandingNetworkApi(
        client: OkHttpClient,
        gson: Gson,
        baseUrl: BaseUrl
    ): BrandingNetworkApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl.getCaravanBase())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory(gson))
            .build()
            .create(BrandingNetworkApi::class.java)
    }
}