package com.likeminds.likemindsfeed.di

import android.app.Application
import com.likeminds.likemindsfeed.SDKApplication
import com.likeminds.likemindsfeed.di.internalsdk.SDKModule
import com.likeminds.likemindsfeed.di.internalsdk.SharedModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModule::class, SDKModule::class])
internal interface LikeMindsFeedComponent {

    fun inject(sdkApplication: SDKApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LikeMindsFeedComponent
    }
}