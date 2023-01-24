package com.likeminds.likemindsfeed.di

import android.app.Application
import com.likeminds.likemindsfeed.sdk.LikeMindsFeedApplication
import com.likeminds.likemindsfeed.di.internalsdk.SDKModule
import com.likeminds.likemindsfeed.di.internalsdk.SharedModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModule::class, SDKModule::class])
internal interface LikeMindsFeedComponent {

    fun inject(likeMindsFeedApplication: LikeMindsFeedApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LikeMindsFeedComponent
    }
}